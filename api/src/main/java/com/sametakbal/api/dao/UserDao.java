package com.sametakbal.api.dao;

import com.sametakbal.api.dao.interfaces.IUserDao;
import com.sametakbal.api.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.UUID;

@Repository
public class UserDao implements IUserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public boolean save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(UUID uuid) {
        Session session = entityManager.unwrap(Session.class);
        User tmp = session.get(User.class, uuid);
        if (tmp == null) {
            return false;
        }
        session.delete(tmp);
        session.close();
        return false;
    }

    @Override
    public boolean get() {
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        Session session = entityManager.unwrap(Session.class);
        try {
            User user = (User) session.createQuery("FROM User u where u.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return true;
        }
        return false;
    }
}
