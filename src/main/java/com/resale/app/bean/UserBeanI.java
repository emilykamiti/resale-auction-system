package com.resale.app.bean;

import com.resale.app.model.entity.User;

public interface UserBeanI {
    boolean register(User user);

    boolean unregister(User user);
}
