package com.mydiaryapplication.userdiary.dao;

import com.mydiaryapplication.userdiary.entity.User;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(user);
    }

    @Override
    public User get(String userId)
    {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, userId);
    }

    @Override
    public void delete(String userId)
    {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, userId);
        currentSession.delete(user);
    }

    @Override
    public boolean searchForId(String userId) {

        Session currentSession = entityManager.unwrap(Session.class);

        User user = currentSession.get(User.class, userId);

        return (user == null);
    }

    @Override
    public boolean searchForMail(String userId,String mailId) {

        Session currentSession = entityManager.unwrap(Session.class);

        String searchForMail = "from User where email =: email";


        Query query = currentSession.createQuery(searchForMail, User.class);

        query.setParameter("email", mailId);

        User user = (User)query.uniqueResult();

        return (user == null);
    }

    @Override
    public User searchForUser(String userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, userId);
    }

    @Override
    public List<User> findAllUsers() {
        Session currentSession = entityManager.unwrap(Session.class);
        List<User> totalUsers = currentSession.createQuery("from User", User.class).list();
        return totalUsers;
    }


}
