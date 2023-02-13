package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;

	@Transactional
	public Event getEventById(Long id) {
		try {
			return eventDAL.getById(id);
		} catch (Exception e) {
			throw new NotFoundException("No event found with id:  "+id);
		}
	}

	@Transactional
	public List<Event> getAllEvents() {
		try {
			return eventDAL.getAllEvents();
		} catch (Exception e) {
			throw new NotFoundException("No events found.");
		}
	}

	@Transactional
	public List<Event> getAllEventsByLocation(String location) {
		try {
			return eventDAL.getAllEventsByLocation(location);
		} catch (Exception e) {
			throw new NotFoundException("No events found for location: " + location);
		}
	}

	public EventScheduleDetail getEventScheduleDetailByEventId(Long id) {
		try {
			return eventDAL.getEventScheduleDetailByEventId(id);
		} catch (Exception e) {
			throw new NotFoundException("Event schedule detail not found for event with id: " + id);
		}
	}

	public List<Ticket> getAllTicketsOfEvent(Long id) {
		try {
			return eventDAL.getAllTicketsOfEvent(id);
		} catch (Exception e) {
			throw new NotFoundException("No tickets found for event with id: " + id);
		}
	}

	@Transactional
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(Long price) {
		try {
			return eventDAL.getAllEventsHavingTicketPriceGreaterThan(price);
		} catch (Exception e) {
			throw new NotFoundException("No events found with ticket price greater than: " + price);
		}
	}

	@Transactional
	public String saveEvent(Event newEvent) {
		List<Event> allEvents = getAllEvents();
		for(Event event : allEvents)
		{
			if(event.getId()==newEvent.getId())
			{
				throw new ElementAlreadyExistException("This event already exist.");
			}
		}
		try {
			return eventDAL.save(newEvent);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for event is invalid.");
		}
	}

	@Transactional
	public String delete(Long id) {
		List<Event> allEvents = getAllEvents();

		boolean isEntityPresent=false;
		for(Event event : allEvents)
		{
			if(event.getId()==id)
			{
				isEntityPresent=true;
			}
		}
		if(isEntityPresent==false)
		{
			throw new InvalidInputException("This event doesn't exist.");
		}
		try{
			return eventDAL.delete(id);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting event.");
		}
	}

	@Transactional
	public String deleteEventScheduleDetail(Long id) {
		try{
			return eventDAL.deleteEventScheduleDetail(id);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
		}
	}

	@Transactional
	public void update(Event updateEvent) {
		try{
			eventDAL.update(updateEvent);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
		}
	}
}
