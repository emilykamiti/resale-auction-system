package com.resale.app.bean;
import java.sql.SQLException;

import javax.ejb.Stateless;

import com.resale.app.model.entity.User;


@Stateless
public class UserBean extends GenericBean<User> implements UserBeanI {

    @Override
    public boolean register(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
        throw new RuntimeException("Password & confirm password do not match");


    getDao().addOrUpdate(user);

    return false;
}

@Override
public boolean unregister(User user) {
    return true;
}
}