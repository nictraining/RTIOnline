package com.example.rtionlinepj.dao;

import com.example.rtionlinepj.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findByUsername(String username) {
        try {
            String jpql = "SELECT u FROM User u WHERE u.username = :username";
            return entityManager.createQuery(jpql, User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
