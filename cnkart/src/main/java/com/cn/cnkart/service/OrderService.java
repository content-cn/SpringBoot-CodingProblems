package com.cn.cnkart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.OrderDAL;
import com.cn.cnkart.entity.Order;

@Service
public class OrderService {

    @Autowired
    OrderDAL orderDAL;

    @Transactional
    public Order getOrderById(int id) {
        return orderDAL.getById(id);
    }

    @Transactional
    public void saveOrder(Order order) {

        orderDAL.save(order);
    }

    @Transactional
    public void delete(int id) {
        orderDAL.delete(id);

    }

}
