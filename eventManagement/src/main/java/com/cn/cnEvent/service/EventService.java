package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnEvent.entity.Ticket;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;

	@Transactional
	public Event getEventById(Long id) {
		return eventDAL.getById(id);
	}

	@Transactional
	public List<Event> getAllEvents() {
		return eventDAL.getAllEvents();
	}

	@Transactional
	public List<Event> getAllEventsByLocation(String location) {
		return eventDAL.getAllEventsByLocation(location);
	}

	public EventScheduleDetail getEventScheduleDetailByEventId(Long id) {
		return eventDAL.getEventScheduleDetailByEventId(id);
	}

	public List<Ticket> getAllTicketsOfEvent(Long id) {
		return eventDAL.getAllTicketsOfEvent(id);
	}

	@Transactional
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(Long price) {
		return eventDAL.getAllEventsHavingTicketPriceGreaterThan(price);
	}

	@Transactional
	public String saveEvent(Event event) {
		return eventDAL.save(event);
	}

	@Transactional
	public String delete(Long id) {
		return eventDAL.delete(id);
	}

	@Transactional
	public String deleteEventScheduleDetail(Long id) {
		return eventDAL.deleteEventScheduleDetail(id);
	}

	@Transactional
	public void update(Event updateEvent) {
		eventDAL.update(updateEvent);
	}
}
