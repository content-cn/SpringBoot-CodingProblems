package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class APIDalImpl implements APIDal {

    @Autowired
    EntityManager entityManager;

    @Override
    public User getUserById(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class,id);
    }
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
    public User findUser(User newUser) {
        Session session = entityManager.unwrap(Session.class);
        for(User user:getAllUsers())
        {
            if(user.getUsername().equalsIgnoreCase(newUser.getUsername()))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return user;
    }

    @Override
    public Income getIncomeById(Integer id){
        Session session = entityManager.unwrap(Session.class);
        return session.get(Income.class,id);
    }

    @Override
    public Income saveIncome(User user,Income newIncome) {
        Session session = entityManager.unwrap(Session.class);
        Income income =new Income();
        income.setAmount(newIncome.getAmount());
        income.setDate(newIncome.getDate());
        income.setDescription(newIncome.getDescription());
        session.save(income);
        for(IncomeType incomeType: newIncome.getIncomeTypes())
        {
            IncomeType newIncomeType=new IncomeType();
            newIncomeType.setName(incomeType.getName());
            newIncomeType.setIncome(income);
            session.save(newIncomeType);
        }
        User newUser=getUserById(user.getId());
        newUser.getIncomes().add(income);
        income.getUsers().add(user);
        session.saveOrUpdate(income);
        session.saveOrUpdate(newUser);
        return income;
    }

    @Override
    public Income saveExpense(Income income, Expense newExpense) {

        Session session = entityManager.unwrap(Session.class);
        Integer expenseId = (Integer) session.save(newExpense);
        Expense expense = session.get(Expense.class, expenseId);
        income = session.get(Income.class, income.getId());
        income.setExpense(expense);
        session.update(income);
        for (ExpenseType expenseType : newExpense.getExpenseTypes()) {
            expenseType.setExpense(expense);
            session.save(expenseType);
        }
        session.flush();
        return income;
    }
}


