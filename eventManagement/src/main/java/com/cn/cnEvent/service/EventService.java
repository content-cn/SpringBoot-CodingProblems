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
	public void delete(int id) {
		eventDAL.delete(id);
		
	}

	@Transactional
	public void update(Event updateEvent) {
		eventDAL.update(updateEvent);
	}

	@Transactional
	public List<Event> getAllEvents() {
		return eventDAL.getAllEvents();
	}
}
