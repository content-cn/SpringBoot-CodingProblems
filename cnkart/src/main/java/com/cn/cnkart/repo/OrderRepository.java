package com.cn.cnkart.repo;

import com.cn.cnkart.entity.Order;
import com.cn.cnkart.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    List<Payment> findByPaymentId(Integer paymentId);
}
