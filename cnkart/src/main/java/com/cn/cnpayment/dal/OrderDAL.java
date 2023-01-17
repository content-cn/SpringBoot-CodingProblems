package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Order;
import java.util.List;

public interface OrderDAL {

    Order getById(int id);

    void save(Order order);

    void delete(int id);

    List<Order> getAllOrders();
}
