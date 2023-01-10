package railway.com.example.RailwayAndMeal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class controller {

	@Autowired
	private RailwayService railwayservice;		
	
	/*
	 1. Call the required service method
	 2. Add proper annotations for Post Mapping and attaching the
	 RequestBody.
	 */
	public void addTodo(Ticket ticket) {
		
	}
	
	/*
	 1. Call the required service method
	 2. Add proper annotations for Get Mapping.
	 */
	public List<Ticket> getAllTickets(){
		
	}
	
	/*
	 1. Call the required service method.
	 2. Add proper annotations for Get Mapping and attaching the
	 Path Variable to the method parameter.
	 */
	public Ticket getTicketByPnr(long pnr) {
		
	}	

}
