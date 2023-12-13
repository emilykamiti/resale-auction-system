package com.resale.app.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.resale.app.model.entity.AuditLog;
import com.resale.app.model.entity.User;
import com.resale.app.utility.EncryptText;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class AuthBean extends GenericBean<User> implements AuthBeanI, Serializable {
    // @EJB
    // MysqlDatabaseTodelete database;
    @PersistenceContext
    EntityManager em;

    @Inject
    private EncryptText hashText;

    @Inject
    private Event<AuditLog> logger;

    public User authenticate(User loginUser) throws SQLException {

        try {
            loginUser.setPassword(hashText.encrypt(loginUser.getPassword()));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        TypedQuery<User> query = em.createQuery("FROM User u WHERE u.username=:username AND u.password=:password",
                User.class);
        query.setParameter("username", loginUser.getUsername());
        query.setParameter("password", loginUser.getPassword());

        List<User> users = query.getResultList();

        if (users.isEmpty()) {
            throw new RuntimeException("Invalid user!!");
        }

        User user = users.get(0);

        AuditLog log = new AuditLog();
        log.setLogDetails(
                user.getUsername() + " logged in at " + DateFormat.getDateTimeInstance().format(new Date()) + ".");

        em.persist(log);

        logger.fire(log);

        return user;

    }

}