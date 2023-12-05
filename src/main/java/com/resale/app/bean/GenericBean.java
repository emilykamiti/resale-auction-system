package com.resale.app.bean;


import java.util.List;


import com.resale.app.dao.GenericDao;
import com.resale.app.dao.GenericDaoI;

public  abstract class GenericBean<T> implements GenericBeanI<T>{

     private final GenericDaoI<T> genericDao = new GenericDao<>();

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        return genericDao.list(entity);

    }
    @Override
    public T fetchItem(Class<T> entityClass, Long id) { 
        return genericDao.fetch(entityClass, id);
    }

    @Override
    public void addOrUpdate(T entity) {

        genericDao.addOrUpdate(entity);

    }

    public GenericDao<T> getDao(){
        return (GenericDao<T>) genericDao;
    }

}