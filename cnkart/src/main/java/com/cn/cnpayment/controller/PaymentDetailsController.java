package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cn.cnpayment.service.PaymentDetailsService;

import java.util.List;

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
