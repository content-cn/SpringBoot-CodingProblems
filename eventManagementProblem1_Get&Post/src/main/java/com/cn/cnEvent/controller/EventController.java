package com.cn.cnEvent.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cn.cnEvent.entity.Event;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	/*
	 1. Call the required service method.
	 2. Add proper annotations for Get Mapping and attaching the
	Path Variable to the method parameter.
	*/
	public Event getEventById(@PathVariable int id) {

	}

	/*
	 1. Call the required service method
	 2. Add proper annotations for Get Mapping.
	 */
	public List<Event> getAllEvents() {

	}

	/*
	 1. Call the required service method
	 2. Add proper annotations for Post Mapping and attaching the
	 RequestBody.
	 */
	public void saveEvent(@RequestBody Event event) {

	}
	
}
