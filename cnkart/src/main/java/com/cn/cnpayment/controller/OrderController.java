package com.cn.cnpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnpayment.entity.Order;
import com.cn.cnpayment.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable int id)
    {
        return orderService.getOrderById(id);
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody Order order)
    {
        orderService.saveOrder(order);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteOrder(@PathVariable int id)
    {
        orderService.delete(id);
    }

}
