package com.cn.cnkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnkart.service.PaymentDetailsService;

@RestController
@RequestMapping("/details")
public class PaymentDetailsController {

	@Autowired
	PaymentDetailsService paymentDetailsService;
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id)
	{
		paymentDetailsService.delete(id);
	}
}
