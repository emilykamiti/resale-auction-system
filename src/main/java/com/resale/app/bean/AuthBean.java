package com.resale.app.bean;

import java.io.Serializable;

import com.resale.app.model.entity.User;
import com.resale.database.Database;

public class AuthBean implements AuthBeanI, Serializable {

    Database database = Database.getDbInstance();

    public User authenticate(User loginUser) {

        User userDetails = null;

        for (User user : database.getUsers()) {
            if (loginUser.getUsername().equals(user.getUsername())
                    && loginUser.getPassword().equals(user.getPassword())) {
                userDetails = user;

                break;

            }
        }

        return userDetails;
    }
}
