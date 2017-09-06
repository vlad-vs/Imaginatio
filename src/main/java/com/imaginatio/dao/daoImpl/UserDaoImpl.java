package com.imaginatio.dao.daoImpl;

import com.imaginatio.dao.UserDao;
import com.imaginatio.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public User findByEmail(String email) {
        User user = entityManager.createQuery("SELECT c FROM User c WHERE c.email like :userEmail", User.class)
                .setParameter("userEmail", email).getSingleResult();
        return user;
    }

    @Transactional
    @Override
    public User findByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
}

