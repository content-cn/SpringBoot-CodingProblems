package com.cn.cnEvent.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;

import java.util.List;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;
	
	@Transactional
	public Event getEventById(int id) {
		return eventDAL.getById(id);
	}

	@Transactional
	public void saveEvent(Event event) {
		
		eventDAL.save(event);
	}

	@Transactional
	public List<Event> getAllEvents() {
		return eventDAL.getAllEvents();
	}

	//Complete the method body to delete a event by id.
	public void delete(int id) {
		
	}

	//Complete the method body to update an existing event.
	public void update(Event updateEvent) {

	}
}
