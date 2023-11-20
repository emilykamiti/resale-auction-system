package com.resale.app.bean;



import java.sql.SQLException;

import com.resale.app.model.entity.User;

public interface UserBeanI {

    boolean register(User user) throws SQLException;

    boolean unregister(User user);
}
