package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.Order;
import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.service.PaymentDetailsService;

@RestController
@RequestMapping("/details")
public class PaymentDetailsController {

	@Autowired
	PaymentDetailsService paymentDetailsService;

	@GetMapping("/id/{id}")
	public PaymentDetails getPaymentDetailsById(@PathVariable int id)
	{
		return paymentDetailsService.getPaymentDetailsById(id);
	}

	@PostMapping("/save")
	public void savePaymentDetails(@RequestBody PaymentDetails paymentDetails)
	{
		paymentDetailsService.savePaymentDetails(paymentDetails);
	}
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id)
	{
		paymentDetailsService.delete(id);
	}
}
