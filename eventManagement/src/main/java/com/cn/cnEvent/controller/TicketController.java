package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Ticket;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class TicketController {

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         id from URL using PathVariable.
    */
    public Ticket getTicketById(@PathVariable Long id) {
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping.
    */
    public List<Ticket> getAllTickets(){
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         age from URL using PathVariable.
    */
    public List<Ticket> getAllTicketsByAge(@PathVariable Long age) {
    }
}
