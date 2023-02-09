package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.TicketService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDALImpl implements TicketDAL {

	@Autowired
	EntityManager entityManager;

	@Autowired
	TicketService ticketService;
	
	@Override
	public Ticket getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Ticket ticket = session.get(Ticket.class, id);
		return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() {
		Session session = entityManager.unwrap(Session.class);
		List<Ticket> allTickets= session.createQuery(
				"SELECT t FROM Ticket t", Ticket.class).getResultList();
		return allTickets;
	}

	@Override
	public List<Ticket> getAllTicketsByAge(Long age){
		Session session = entityManager.unwrap(Session.class);
		List<Ticket> allTickets=ticketService.getAllTickets();
		List<Ticket> allTicketsByAge= new ArrayList<>();

		for(Ticket ticket : allTickets)
		{
			if(ticket.getPerson().getAge()<18)
			{
				allTicketsByAge.add(ticket);
			}
		}
		return allTicketsByAge;
	}

	@Override
	public String save(Ticket ticket) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ticket);
		return "The ticket was saved successfully.";
	}

	@Override
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Ticket ticket = session.get(Ticket.class, id);
		session.delete(ticket);
		return "The ticket was deleted successfully";
	}
	
	@Override
	public void update(Ticket updateTicket) {
		Session session = entityManager.unwrap(Session.class);
		Ticket currentTicket = session.get(Ticket.class, updateTicket.getId());
		currentTicket.setName(updateTicket.getName());
		session.update(currentTicket);
	}
}
