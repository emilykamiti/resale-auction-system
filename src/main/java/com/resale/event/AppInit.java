package com.resale.event;

import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.resale.database.MysqlDatabase;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MysqlDatabase.updateSchema();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            MysqlDatabase database = MysqlDatabase.getInstance();
            if (database.getConnection() != null) {
                database.getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}