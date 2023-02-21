package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import com.example.cnExpense.jspEntities.Choice;
import com.example.cnExpense.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ViewController {

	@Autowired
	private APIService apiService;

	@GetMapping({"", "/home"})
	public String home() {
		return "home";
	}
	@GetMapping("/error")
	public String error() {

		System.out.println("OOPS you have an error.");
		return "error";
	}

	@GetMapping("/processHomePage")
	public String processHomePage(@ModelAttribute("choice")Choice choice, Model model) {
		System.out.println(choice.getChoice());
		model.addAttribute(new User());
		if(choice.getChoice().equalsIgnoreCase("Yes"))
		{

			return "login";
		}
		else
		{
			return "register";
		}
	}

	@GetMapping("/processLoginPage")
	public String processLoginPage(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {

		if(request.getParameter("submit").equals("register"))
		{
			return "register";
		}
		if(apiService.checkUserExist(user))
		{
			model.addAttribute("action", "logged into");
			model.addAttribute("redirectPageName","Income");
			System.out.println(request.getContextPath()+"income");
			model.addAttribute("redirectPage","income");

			model.addAttribute(user);
			return "success";
		}
		else
		{
			model.addAttribute(user);
			model.addAttribute("action", "login");
			model.addAttribute("redirectPageName","Home");
			model.addAttribute("redirectPage","home");
			return "failure";
		}
	}

	@GetMapping({"/processSuccessPage","/processFailurePage"})
	public String processSuccessAndFailurePage(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {

		System.out.println("Success and failure page will redirect to "+request.getParameter("redirectPage"));
		if(request.getParameter("redirectPage").equals("income"))
		{
			model.addAttribute(new Income());
		}
		if(request.getParameter("redirectPage").equals("expense"))
		{
			model.addAttribute(new Expense());
		}
		return request.getParameter("redirectPage");
	}

	@GetMapping("/processRegisterPage")
	public String processRegisterPage(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {

		if(request.getParameter("submit").equals("login"))
		{
			return "login";
		}
		System.out.println("Process Register"+user.getUsername()+" "+user.getEmail()+" "+user.getNickname());
		List<User>allUsers=apiService.getAllUsers();
		if(apiService.checkUserExist(user)==false)
		{
			apiService.save(user);
			model.addAttribute("action", "registered into");
			model.addAttribute("redirectPageName","Home");
			model.addAttribute("redirectPage","home");
			model.addAttribute(user);
			return "success";
		}
		else
		{
			model.addAttribute("action", "register");
			model.addAttribute("redirectPageName","Registration");
			model.addAttribute("redirectPage","register");
			model.addAttribute("message","User already exist.");
			model.addAttribute(user);

			return "failure";
		}
	}

	@GetMapping("/processIncomePage")
	public String processIncomePage(HttpServletRequest request, @ModelAttribute("income") Income income, Model model) {
		System.out.println(income.getAmount()+" "+income.getDate()+" "+income.getDescription());
		//Add income to database
		//something
		if(true)
		{
			model.addAttribute("action", "add income");
			model.addAttribute("redirectPageName","Expense");
			model.addAttribute("redirectPage","expense");
			//Pass income Id
			return "success";
		}
		else
		{
			model.addAttribute("action", "add income");
			model.addAttribute("redirectPageName","Income");
			model.addAttribute("redirectPage","income");
			return "failure";
		}
//		return "income";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
