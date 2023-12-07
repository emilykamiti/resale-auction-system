package com.resale.app.bean;

import java.sql.SQLException;

import com.resale.app.model.entity.User;

public interface AuthBeanI {

    User authenticate(User loginUser) throws SQLException;
}