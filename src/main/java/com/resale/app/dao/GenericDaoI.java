
package com.resale.app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI <T> extends Serializable {

   

    List<T> list(Class<?> entity);
    
    void addOrUpdate(T entity);

    void delete(Class<?> entityClass, Long id);

    T fetch(Class<T> entityClass, Long id);


}
