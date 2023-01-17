package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;
import com.cn.cnpayment.entity.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDALImpl implements OrderDAL {

    @Autowired
    EntityManager entityManager;

    @Override
    public Order getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Order order = session.get(Order.class, id);
        return order;
    }
    
    @Override
    public List<Order> getAllOrders() {
        Session session = entityManager.unwrap(Session.class);
        List<Order> allOrders= session.createQuery(
                "SELECT p FROM Order p", Order.class).getResultList();
        return allOrders;
    }

    @Override
    public void save(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.save(order);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Order order = session.get(Order.class, id);
        session.delete(order);

    }
}
