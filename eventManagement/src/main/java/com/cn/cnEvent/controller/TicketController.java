package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class TicketController {

    public Ticket getTicketById(@PathVariable Long id) {
    }

    public List<Ticket> getAllTickets(){
    }

    public List<Ticket> getAllTicketsByAge(@PathVariable Long age) {
    }
}
