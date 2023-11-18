package com.resale.app.bean;




import java.io.Serializable;

import com.resale.app.model.entity.User;
import com.resale.database.Database;

public class AuthBean implements AuthBeanI, Serializable {

    Database database = Database.getDbInstance();

    public User authenticate(User loginUser) {
        return (User) database.getData(User.class)
            .stream()
            .filter(user -> ((User)user).getUsername().equals(loginUser.getUsername())
                    && ((User)user).getPassword().equals(loginUser.getPassword()))
            .findAny()
            .orElse(null);
    }
}
