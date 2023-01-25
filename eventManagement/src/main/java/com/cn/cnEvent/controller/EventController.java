package com.cn.cnEvent.controller;

import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Event;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/id/{id}")
	public Event getEventById(@PathVariable int id)
	{
		return eventService.getEventById(id);
	}

	@GetMapping("/allEvents")
	public List<Event> getAllEvents()
	{
		return eventService.getAllEvents();
	}
	
	@PostMapping("/save")
	public void saveEvent(@RequestBody Event event)
	{
		eventService.saveEvent(event);
	}

	/*
	 1. Call the required service method
	 2. Add proper annotations for Delete Mapping and fetch the
	 	Id from PathVariable.
	 */
	public void deleteEvent(@PathVariable int id) {

	}

	/*
	 1. Call the required service method
	 2. Add proper annotations for Update Mapping and use RequestBody
	 annotation to bind the request body to event.
	 */
	public void updateEvent(@RequestBody Event updateEvent) {

	}

}
