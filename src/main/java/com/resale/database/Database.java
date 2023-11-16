package com.resale.database;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.resale.app.model.entity.Item;
import com.resale.app.model.entity.User;



public class Database implements Serializable {

    private String databaseCreateAt;

    private List<User> users = new ArrayList<>();

    private List<Item> items = new ArrayList<>();

    private static Database dbInstance;

    private Database(){}

    public static Database getDbInstance() {  
        if (dbInstance == null) {
            dbInstance = new Database();
            dbInstance.databaseCreateAt = DateFormat.getDateTimeInstance().format(new Date());
            System.out.println("Database created at " + dbInstance.getDatabaseCreateAt());
        }

        return dbInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setAccounts(List<Item> items) {
        this.items = items;
    }

    public String getDatabaseCreateAt() {
        return databaseCreateAt;
    }

}