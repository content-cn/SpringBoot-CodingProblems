package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class APIDalImpl implements APIDal {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<User> allUsers= session.createQuery(
                "SELECT e FROM User e", User.class).getResultList();
        return allUsers;
    }

    @Override
    public boolean checkUserExist(User user){
        boolean userExist=false;
        for (User everyUser: getAllUsers()) {
            if (everyUser.getUsername().equalsIgnoreCase(user.getUsername())) {
                userExist = true;
            }
        }
        return userExist;
    }

    @Override
    public String save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return "The event was saved successfully.";
    }
}


