package com.resale.database;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;
import com.resale.app.model.entity.ItemType;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.resale.app.model.entity.User;
import com.resale.database.helper.DbTable;
import com.resale.database.helper.DbTableColumn;
import com.resale.database.helper.DbTableId;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.math.BigDecimal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MysqlDatabase implements Serializable {

    private static MysqlDatabase database;

    private DataSource dataSource;

    private MysqlDatabase() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:jboss/datasources/resale");
        } catch (NamingException e) {
            throw new RuntimeException("Error looking up DataSource in JNDI", e);
        }
    }

    public static MysqlDatabase getInstance() {
        if (database == null) {
            database = new MysqlDatabase();
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

                    if (field.isAnnotationPresent(DbTableId.class)) {
                        sqlBuilder.append(dbTableColumn.name()).append(" SERIAL PRIMARY KEY,");
                    } else {
                        sqlBuilder.append(dbTableColumn.name()).append(" ")
                                .append(dbTableColumn.definition()).append(",");
                    }
                }

                sqlBuilder.append(")");

                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
                System.out.println("Creating table: " + tableCreationSql);
                connection.prepareStatement(tableCreationSql).executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void insert(Object entity) {

        try {

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
                if (!field.isAnnotationPresent(DbTableColumn.class)
                        || field.isAnnotationPresent(DbTableId.class))
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
                if (param instanceof BigDecimal)
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                else if (param instanceof Long)
                    sqlStmt.setLong(paramIdx++, (long) param);
                else if (param instanceof ItemType) {
                    sqlStmt.setString(paramIdx++, ((ItemType) param).name());
                } else if (param instanceof Double) {
                    sqlStmt.setDouble(paramIdx++, (double) param);
                } else
                    sqlStmt.setString(paramIdx++, param.toString());
            }
            sqlStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> fetch(Class<?> entity) {
        try {
            Class<?> clazz = entity;
            System.out.println();
            System.out.println("Clazz>>>>>>>>>>" + clazz.getName());

            if (!clazz.isAnnotationPresent(DbTable.class))
                return new ArrayList<>();

            DbTable dbTable = clazz.getAnnotation(DbTable.class);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM ")
                    .append(dbTable.name()).append(";");
            Connection conn = MysqlDatabase.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(stringBuilder.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> result = new ArrayList<>();

            while (resultSet.next()) {
                T object = (T) clazz.getDeclaredConstructor().newInstance();
                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

                for (Field field : fields) {
                    field.setAccessible(true);
                    DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
                    if (dbColumn != null) {
                        String columnName = dbColumn.name();

                        if (field.getType().isEnum()) {
                            String enumValue = resultSet.getString(columnName);
                            if (enumValue != null) {
                                Object enumConstant = Enum.valueOf((Class<Enum>) field.getType(), enumValue);
                                field.set(object, enumConstant);
                            }
                        } else if (field.getType() == double.class) {
                            double value = resultSet.getDouble(columnName);
                            field.set(object, value);
                        } else if (field.getType() == int.class) {
                            int value = resultSet.getInt(columnName);
                            if (field.getType() == Long.class) {
                                field.set(object, (long) value);
                            } else {
                                field.set(object, value);
                            }
                        } else if (field.getType() == Long.class) {
                            long value = resultSet.getLong(columnName);
                            field.set(object, value);
                        } else {
                            Object value = resultSet.getObject(columnName);
                            field.set(object, value);
                        }
                    }
                }

                result.add(object);

            }

            return result;

        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
                | NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T fetchItem(Class<T> entityClass, Long id) {
        try {
            if (!entityClass.isAnnotationPresent(DbTable.class))
                return null;

            DbTable dbTable = entityClass.getAnnotation(DbTable.class);

            String query = "SELECT * FROM " + dbTable.name() + " WHERE id = ?";

            Connection conn = MysqlDatabase.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            T object = entityClass.getDeclaredConstructor().newInstance();
            List<Field> fields = new ArrayList<>(Arrays.asList(entityClass.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(entityClass.getDeclaredFields()));

            for (Field field : fields) {
                field.setAccessible(true);
                DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
                if (dbColumn != null) {
                    String columnName = dbColumn.name();

                    if (field.getType().isEnum()) {
                        String enumValue = resultSet.getString(columnName);
                        if (enumValue != null) {
                            Object enumConstant = Enum.valueOf((Class<Enum>) field.getType(), enumValue);
                            field.set(object, enumConstant);
                        }
                    } else if (field.getType() == double.class) {
                        double value = resultSet.getDouble(columnName);
                        field.set(object, value);
                    } else if (field.getType() == int.class) {
                        int value = resultSet.getInt(columnName);
                        if (field.getType() == Long.class) {
                            field.set(object, (long) value);
                        } else {
                            field.set(object, value);
                        }
                    } else if (field.getType() == Long.class) {
                        long value = resultSet.getLong(columnName);
                        field.set(object, value);
                    } else {
                        Object value = resultSet.getObject(columnName);
                        field.set(object, value);
                    }
                }
            }

            return object;

        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
                | NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource is null. Initialization error.");
        }

        return dataSource.getConnection();
    }

    public static void deleteItem(Class<?> clazz, Long id) {
        try {
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("DELETE FROM ").append(dbTable.name()).append(" WHERE id = ?");

            String query = queryBuilder.toString();
            System.out.println("Delete Query: " + query);

            Connection connection = MysqlDatabase.getInstance().getConnection();
            PreparedStatement sqlStmt = connection.prepareStatement(query);
            sqlStmt.setLong(1, id);

            sqlStmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
