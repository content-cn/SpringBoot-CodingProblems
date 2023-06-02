package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/id/{id}")
    public Ticket getTicketById(@PathVariable Long id)
    {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/allTickets")
    public List<Ticket> getAllTickets()
    {
        return ticketService.getAllTickets();
    }

    @GetMapping("/allTickets/age/{age}")
    public List<Ticket> getAllTicketsByAge(@PathVariable Long age) {
        return ticketService.getAllTicketsByAge(age);
    }
}
