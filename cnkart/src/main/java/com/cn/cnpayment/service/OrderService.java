package com.cn.cnpayment.service;

import javax.transaction.Transactional;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.OrderDAL;
import com.cn.cnpayment.entity.Order;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDAL orderDAL;

    @Transactional
    public Order getOrderById(int id) {
        Order order=orderDAL.getById(id);
        if(order==null)
        {
            throw new NotFoundException("No order found with id:  "+id);
        }
        return order;
    }

    @Transactional
    public List<Order> getAllOrders() {

        List<Order> orders = orderDAL.getAllOrders();
        if(orders==null)
        {
            throw new NotFoundException("No orders found.");
        }
        return orders;
    }

    @Transactional
    public void saveOrder(Order newOrder) {
        List<Order> allOrder = getAllOrders();
        for(Order order : allOrder)
        {
            if(order.getId()==newOrder.getId())
            {
                throw new ElementAlreadyExistException("This order already exist.");
            }
        }
        orderDAL.save(newOrder);
    }

    @Transactional
    public void delete(int id) {
        orderDAL.delete(id);
    }

}
