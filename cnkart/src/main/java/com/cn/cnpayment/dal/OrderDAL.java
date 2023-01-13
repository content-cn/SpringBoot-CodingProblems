package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Order;

public interface OrderDAL {

    Order getById(int id);

    void save(Order order);

    void delete(int id);

//    Set<Payment> getAllPaymentsByOrderId(String orderId);


}
