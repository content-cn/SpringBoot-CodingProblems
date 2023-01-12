package com.cn.cnkart.dal;

import javax.persistence.EntityManager;

import com.cn.cnkart.entity.Payment;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cn.cnkart.entity.Order;

import java.util.List;
import java.util.Set;

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

//    @Override
//    public Set<Payment> getAllPaymentsByOrderId(String orderId){
//        Session session = entityManager.unwrap(Session.class);
//        Order orders = session.get(Order.class, orderId);
//        return orders.getPayments();
//    }
}
