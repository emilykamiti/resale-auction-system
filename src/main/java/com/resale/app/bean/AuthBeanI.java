package com.resale.app.bean;

import com.resale.app.model.entity.User;

public interface AuthBeanI {
     User authenticate(User loginUser); 
}
