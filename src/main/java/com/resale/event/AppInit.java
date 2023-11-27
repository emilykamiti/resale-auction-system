package com.resale.event;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.resale.app.model.entity.Bid;
import com.resale.app.model.entity.Item;
import com.resale.app.model.entity.User;
import com.resale.database.MysqlDatabase;
import com.resale.database.helper.DbTable;
import com.resale.database.helper.DbTableColumn;

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
            if (database.getConnection() != null){
                database.getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}