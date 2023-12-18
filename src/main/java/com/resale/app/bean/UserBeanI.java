package com.resale.app.bean;

import java.sql.SQLException;

import com.resale.app.model.entity.User;

public interface UserBeanI extends GenericBeanI<User> {

    User register(User user) throws SQLException;

    boolean changePwd(User user) throws SQLException;

    boolean unregister(User user);

    User findById(Long userId);
}
