package com.resale.database;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;
import com.resale.app.model.entity.User;
import com.resale.database.helper.DbTable;
import com.resale.database.helper.DbTableColumn;
import com.resale.database.helper.DbTableId;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysqlDatabase implements Serializable {

    private static MysqlDatabase database;
    private Connection connection;

    private MysqlDatabase() throws SQLException, NamingException {
        Context ctx = new InitialContext();

        DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/resale");
        connection = dataSource.getConnection();
    }

    public static MysqlDatabase getInstance() {
        if (database == null) {
            try {
                database = new MysqlDatabase();
            } catch (SQLException | NamingException e) {
                throw new RuntimeException(e);
            }
        }
        return database;

    }

    public static void updateSchema() {
        System.out.println("*************** updating schema database *************");

        try {
            Connection connection = MysqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Item.class);
            entities.add(Bid.class);

            for (Class<?> clazz : entities) {
                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();

                sqlBuilder.append("create table if not exists ").append(dbTable.name()).append("(");

                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;

                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.name()).append(" ")
                            .append(dbTableColumn.definition())
                            .append(field.isAnnotationPresent(DbTableId.class) ? " NOT NULL AUTO_INCREMENT PRIMARY KEY"
                                    : "")
                            .append(",");
                }

                sqlBuilder.append(")");

                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
                System.out.println("Creating table: " + tableCreationSql);
                connection.prepareStatement(tableCreationSql).executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        System.out.println("table created..........................");
    }

    public static void insert(Object entity) {

        try {
            System.out.println("inserting data into table.....................");
            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DbTableId.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.name()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));

            }

            String queryBuilder = "insert into " +
                    dbTable.name() +
                    "(" +
                    columnBuilder +
                    ")" +
                    " values(" +
                    paramPlaceHolderBuilder +
                    ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
                    .prepareStatement(query);

            int paramIdx = 1;
            for (Object param : parameters) {
                if (param instanceof BigDecimal) {
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                } else if (param instanceof Long) {
                    sqlStmt.setLong(paramIdx++, (Long) param);
                } else if (param instanceof Double) {
                    sqlStmt.setDouble(paramIdx++, (Double) param);
                } else if (param instanceof Enum) {
                    sqlStmt.setString(paramIdx++, ((Enum<?>) param).name());
                } else {
                    sqlStmt.setString(paramIdx++, (String) param);
                }
            }
            sqlStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static <T> T select(Class<T> clazz, int id) throws SQLException {
        if (!clazz.isAnnotationPresent(DbTable.class))
            return null;

        DbTable dbTable = clazz.getAnnotation(DbTable.class);

        String query = "select * from " + dbTable.name() + " where id = ?";

        PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection().prepareStatement(query);
        sqlStmt.setInt(1, id);

        ResultSet rs = sqlStmt.executeQuery();

        if (!rs.next())
            return null;

        T entity;
        try {
            entity = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new SQLException(e);
        }

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for (Field field : fields) {
            if (!field.isAnnotationPresent(DbTableColumn.class))
                continue;

            field.setAccessible(true);
            try {
                field.set(entity, rs.getObject(field.getAnnotation(DbTableColumn.class).name()));
            } catch (IllegalAccessException e) {
                throw new SQLException(e);
            }
        }

        return entity;
    }
}