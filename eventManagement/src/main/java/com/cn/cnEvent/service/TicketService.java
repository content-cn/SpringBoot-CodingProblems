package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {

	@Autowired
	TicketDAL ticketDAL;

	@Transactional
	public Ticket getTicketById(Long id) {
		return ticketDAL.getById(id);
	}

	@Transactional
	public List<Ticket> getAllTickets() {
		return ticketDAL.getAllTickets();
	}

	@Transactional
	public List<Ticket> getAllTicketsByAge(Long age) {
		return ticketDAL.getAllTicketsByAge(age);
	}

	@Transactional
	public String saveTicket(Ticket ticket) {
		return ticketDAL.save(ticket);
	}

	@Transactional
	public String delete(Long id) {
		return ticketDAL.delete(id);
	}

	@Transactional
	public void update(Ticket updateTicket) {
		ticketDAL.update(updateTicket);
	}
}
