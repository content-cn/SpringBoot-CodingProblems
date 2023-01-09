package railway.com.example.RailwayAndMeal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import railway.com.example.RailwayAndMeal.Entity.railway;
import railway.com.example.RailwayAndMeal.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class controller {

	
	@Autowired
	private RailwayService todoservice;
//	private TopicService topicService;
//	
	
	
	@RequestMapping("/home")
	public String Welcome() {
		//it will automatically converted JSON object
		return "Welcome to CodingNinjas RailwayTicketBookingApp";
	}
	
	@RequestMapping("/tickets")
	public List<railway> getTicket(){
		
		return todoservice.getTicket();
		
	}
	@RequestMapping("/ticket/{id}")
	public railway getSingleTicket(@PathVariable long id) {
		
		return todoservice.getTicket(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/ticket")
	public void addTodo(@RequestBody railway todo) {
		System.out.print(todo);
		todoservice.addTicket(todo);
//		return todoservice.getTicket();
	}

	
	@RequestMapping(method=RequestMethod.PUT,value="/ticket/{id}")
	public List<railway> updateTodo(@RequestBody railway topic,@PathVariable long id) {
		System.out.print(topic);
		todoservice.updateTicket(topic,id);
		return todoservice.getTicket();
	}

	
	@RequestMapping(method=RequestMethod.DELETE,value="/ticket/{id}")
	public List<railway> deleteTodo(@PathVariable long id) {
		System.out.print(id);
		todoservice.deleteTicket(id);
		return todoservice.getTicket();
	}
}
