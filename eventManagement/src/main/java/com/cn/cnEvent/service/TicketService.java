package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {

	public Ticket getTicketById(Long id) {
	}

	public List<Ticket> getAllTickets() {
	}

	public List<Ticket> getAllTicketsByAge(Long age) {
	}
}
