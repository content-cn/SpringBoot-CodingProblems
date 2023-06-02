package com.cn.cnkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnkart.entity.Payment;
import com.cn.cnkart.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService PaymentService;
	
	@GetMapping("/id/{id}")
	public Payment getPaymentById(@PathVariable int id)
	{
		return PaymentService.getPaymentById(id);
	}
	
	@PostMapping("/save")
	public void savePayment(@RequestBody Payment Payment)
	{
		PaymentService.savePayment(Payment);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public void deletePayment(@PathVariable int id)
	{
		PaymentService.delete(id);
	}

	@PutMapping("/update/{id}/description/{description}")
	public void updateDescription(@PathVariable("id") int id, @PathVariable("description") String description)
	{
		PaymentService.updateDescription(id,description);
	}
	
}
