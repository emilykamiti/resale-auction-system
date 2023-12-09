package com.resale.app.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.resale.app.dao.GenericDao;
import com.resale.app.dao.GenericDaoI;

import java.util.List;

public abstract class GenericBean<T> implements GenericBeanI<T>{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private GenericDaoI<T> genericDao;

    @Override
    public List<T> list(T entity) {
        genericDao.setEm(em);
        return genericDao.list(entity);

    }

    @Override
    public T addOrUpdate(T entity) {
        genericDao.setEm(em);
        return genericDao.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {

    }

    public GenericDao<T> getDao(){
        genericDao.setEm(em);
        return (GenericDao<T>) genericDao;
    }

}
