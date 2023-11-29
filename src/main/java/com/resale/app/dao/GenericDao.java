package com.resale.app.dao;


import java.util.List;


import com.resale.database.MysqlDatabase;

public class GenericDao<T> implements GenericDaoI<T> {

    @SuppressWarnings({"unchecked"})
    @Override
    public List<T> list(Class<?> entity) {
        return  (List<T>) MysqlDatabase.fetch(entity);

    }

    @Override
    public void addOrUpdate(T entity) {
        MysqlDatabase.insert(entity);

    }

    @Override
    public void delete(Class<?> entityClass, Long id) {
        MysqlDatabase.deleteItem(entityClass, id);
    }
}
