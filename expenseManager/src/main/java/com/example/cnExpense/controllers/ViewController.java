package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.*;
import com.example.cnExpense.jspEntities.Choice;
import com.example.cnExpense.service.ExpenseService;
import com.example.cnExpense.service.IncomeService;
import com.example.cnExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController{


	public static Integer userid;
	public static Integer incomeid;

	@Autowired
	private UserService userService;

	@Autowired
	private IncomeService incomeService;

	@Autowired
	private ExpenseService expenseService;

	@GetMapping({"", "/home"})
	public String home() {
		return "home";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}

	@GetMapping("/processHomePage")
	public String processHomePage(@ModelAttribute("choice")Choice choice, Model model) {
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
		if(userService.checkUserExist(user))
		{
			model.addAttribute("action", "logged into");
			model.addAttribute("redirectPageName","Income");
			model.addAttribute("redirectPage","income");
			User savedUser=userService.findUser(user);
			userid=savedUser.getId();
			return "success";
		}
		else
		{
			model.addAttribute("action", "login");
			model.addAttribute("redirectPageName","Home");
			model.addAttribute("redirectPage","home");
			return "failure";
		}
	}

	@GetMapping({"/processSuccessPage","/processFailurePage"})
	public String processSuccessAndFailurePage(HttpServletRequest request, Model model) {

		if(request.getParameter("redirectPage").equals("income"))
		{
			model.addAttribute(new Income());
		}
		else if(request.getParameter("redirectPage").equals("expense"))
		{
			model.addAttribute(new Expense());
		}
		else if(request.getParameter("redirectPage").equals("dashboardCalendar")){

			List<User>users=userService.getAllUsers();
			model.addAttribute("users",users);
		}
		return request.getParameter("redirectPage");
	}

	@GetMapping("/processRegisterPage")
	public String processRegisterPage(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {

		if(request.getParameter("submit").equals("login"))
		{
			return "login";
		}
		if(userService.checkUserExist(user)==false)
		{
			userService.saveUser(user);
			model.addAttribute("action", "registered into");
			model.addAttribute("redirectPageName","Home");
			model.addAttribute("redirectPage","home");
			return "success";
		}
		else
		{
			model.addAttribute("action", "register");
			model.addAttribute("redirectPageName","Registration");
			model.addAttribute("redirectPage","register");
			model.addAttribute("message","User already exist.");
			return "failure";
		}
	}

	@GetMapping("/processIncomePage")
	public String processIncomePage(HttpServletRequest request, @ModelAttribute("income") Income income, Model model) {
		User user= userService.getUserById(userid);
		Income savedIncome=incomeService.saveIncome(user,income);
		incomeid=savedIncome.getId();
		if(true)
		{
			model.addAttribute("action", "add income");
			model.addAttribute("redirectPageName","Expense");
			model.addAttribute("redirectPage","expense");
			return "success";
		}
		else
		{
			model.addAttribute("action", "add income");
			model.addAttribute("redirectPageName","Income");
			model.addAttribute("redirectPage","income");
			return "failure";
		}
	}

	@GetMapping("/processExpensePage")
	public String processExpensePage(HttpServletRequest request, @ModelAttribute("expense") Expense expense, Model model) {

		Income checkIncome= incomeService.getIncomeById(incomeid);
		checkIncome=expenseService.saveExpense(checkIncome,expense);

		if(true)
		{
			model.addAttribute("action", "add expense");
			model.addAttribute("redirectPageName","DashboardCalendar");
			model.addAttribute("redirectPage","dashboardCalendar");
			model.addAttribute("income",checkIncome);
			return "success";
		}
		else
		{
			model.addAttribute("action", "add expense");
			model.addAttribute("redirectPageName","Expense");
			model.addAttribute("redirectPage","expense");
			return "failure";
		}
	}


	@GetMapping("/processDashboardCalendarPage")
	public String processDashboardCalendarPage(HttpServletRequest request, Model model, @RequestParam(value = "day", required = false) String day,
											   @RequestParam(value = "month", required = false) String month,
											   @RequestParam(value = "year", required = false) String year) {
		List<User> userList = userService.getAllUsers();
		if(request.getParameter("submit").equals("dashboardType"))
		{
			model.addAttribute("users", userList);
			return "dashboardType";
		}
		List<User> filteredList = new ArrayList<>();
		for (User user : userList) {
			List<Income> filteredIncomes = new ArrayList<>();
			for (Income income : user.getIncomes()) {
				if ((income.getDate()!=null) && (day != null && !day.isEmpty() && !(Integer.parseInt(day)==income.getDate().getDayOfMonth()))) {
					continue;
				}
				else if ((income.getDate()!=null) && (month != null && !month.isEmpty() && !(Integer.parseInt(month)==income.getDate().getMonthValue()))) {
					continue;
				}
				else if ((income.getDate()!=null) && (year != null && !year.isEmpty() && !(Integer.parseInt(year)==income.getDate().getYear()))) {
					continue;
				}
				filteredIncomes.add(income);
			}
			user.setIncomes(filteredIncomes);
			filteredList.add(user);
		}
		model.addAttribute("users", filteredList);
		return "dashboardCalendar";
	}
	@GetMapping("/processDashboardTypePage")
	public String processDashboardTypePage(HttpServletRequest request, Model model, @RequestParam(value = "incomeType", required = false) String incomeType,
											   @RequestParam(value = "expenseType", required = false) String expenseType) {
		List<User> userList = userService.getAllUsers();
		if(request.getParameter("submit").equals("dashboardCalendar"))
		{
			model.addAttribute("users", userList);
			return "dashboardCalendar";
		}
		List<User> filteredList = new ArrayList<>();
		for (User user : userList) {
			List<Income> filteredIncomes = new ArrayList<>();
			for (Income income : user.getIncomes()) {
				if (incomeType != null && !incomeType.isEmpty()) {
					boolean foundIncomeType = false;
					for (IncomeType type : income.getIncomeTypes()) {
						if (type.getName().equalsIgnoreCase(incomeType)) {
							foundIncomeType = true;
							break;
						}
					}
					if (!foundIncomeType) {
						continue;
					}
				}
				else if (expenseType != null && !expenseType.isEmpty()) {
					boolean foundExpenseType = false;
					for (ExpenseType type : income.getExpense().getExpenseTypes()) {
						if (type.getName().equalsIgnoreCase(expenseType)) {
							foundExpenseType = true;
							break;
						}
					}
					if (!foundExpenseType) {
						continue;
					}
				}
				filteredIncomes.add(income);
			}
			user.setIncomes(filteredIncomes);
			filteredList.add(user);
		}
		model.addAttribute("users", filteredList);
		return "dashboardType";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
