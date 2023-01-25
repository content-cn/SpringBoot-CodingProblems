package com.cn.cnEvent.controller;

import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Event;

public class EventController {

	public Event getEventById(@PathVariable int id) {

	}

	public void saveEvent(@RequestBody Event event) {

	}

	public void deleteEvent(@PathVariable int id) {

	}

	public void updateEvent(@RequestBody Event updateEvent){

	}
	
}
