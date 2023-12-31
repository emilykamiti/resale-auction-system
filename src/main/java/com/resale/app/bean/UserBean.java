package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.resale.app.model.entity.User;
import com.resale.app.utility.EncryptText;

import java.sql.SQLException;
import java.util.List;

@Stateless
// @Remote
public class UserBean extends GenericBean<User> implements UserBeanI {

    @Inject
    private EncryptText encryptText;

    @PersistenceContext
    private EntityManager em;

    @Override
    public User register(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new RuntimeException("Password & confirm password do not match");

        System.out.println("Heloooooooooooooooooooooo....");

        // if (!doesUserExistByEmail(user.getEmail())) {
        // throw new RuntimeException("User already exists!");
        // }

        try {
            user.setPassword(encryptText.encrypt(user.getPassword()));

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());

        }

        getDao().addOrUpdate(user);

        return user;
    }

    @Override
    public boolean changePwd(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new RuntimeException("Password & confirm password do not match");

        List<User> checkUser = list(new User(user.getUsername(), user.getOldPassword(), user.getEmail()));
        if (checkUser.isEmpty())
            throw new RuntimeException("User does not exist");

        try {
            checkUser.get(0).setPassword(encryptText.encrypt(user.getPassword()));

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());

        }

        getDao().addOrUpdate(checkUser.get(0));

        return false;
    }

    public User findById(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public boolean unregister(User user) {
        return true;
    }
}
