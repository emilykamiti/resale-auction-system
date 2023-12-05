package com.resale.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

   
    
    List<T> list(Class<?> entity);

    void addOrUpdate(T entity);

    T fetchItem(Class<T> entityClass, Long id);

}
