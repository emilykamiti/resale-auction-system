package com.resale.app.bean;

import com.resale.app.model.entity.User;
import com.resale.app.utility.EncryptText;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UserBean extends GenericBean<User> implements UserBeanI {

    @Inject
    private EncryptText encryptText;

    @Override
    public boolean register(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new RuntimeException("Password & confirm password do not match");

        List<User> checkUser = list(new User(user.getUsername()));
        if (!checkUser.isEmpty())
            throw new RuntimeException("User already exists!");

        try {
            user.setPassword(encryptText.encrypt(user.getPassword()));

        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());

        }


        getDao().addOrUpdate(user);

        return false;
    }

    @Override
    public boolean unregister(User user) {
        return true;
    }
}
