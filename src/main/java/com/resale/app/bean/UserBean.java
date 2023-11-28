package com.resale.app.bean;


import java.io.Serializable;
import java.sql.SQLException;

import com.resale.app.model.entity.User;
import com.resale.database.MysqlDatabase;
public class UserBean implements UserBeanI, Serializable {
    @Override
    public boolean register(User user) throws SQLException {

        if (user.getPassword().equals(user.getConfirmPassword())) {
               MysqlDatabase.insert(user);

            return true;
        }
        return false;
    }
    @Override
    public boolean unregister(User user) {
        return true;
    }
}