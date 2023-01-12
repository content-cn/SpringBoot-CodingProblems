package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Order;
import com.cn.cnkart.entity.Payment;

import java.util.List;
import java.util.Set;

public interface OrderDAL {

    Order getById(int id);

    void save(Order order);

    void delete(int id);

//    Set<Payment> getAllPaymentsByOrderId(String orderId);


}
