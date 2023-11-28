package com.resale.app.bean;


import java.util.List;

import com.resale.database.Database;
import com.resale.database.MysqlDatabase;

public class GenericBean<T> implements GenericBeanI<T>{

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        return (List<T>) 
        Database.getDbInstance().getData(entity);

    }

    @Override
    public void addOrUpdateAccount(T entity) {

       
      MysqlDatabase.insert(entity);
    }

    @Override
    public void deleteAccount(T entity) {

    }
}
