package com.resale.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    List<T> list(T entity);

    T addOrUpdate(T entity);

    void delete(T entity);

    public void delete(Class<?> entityClass, Long id);

    T findById(Class<T> entity, Long id);

    public boolean doesUserExistByEmail(String email);

    T getById(Class<T> entityClass, Long id);

    T findByUserName(Class<T> entity, String userName);
}
