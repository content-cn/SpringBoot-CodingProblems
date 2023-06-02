package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.PaymentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.service.PaymentReviewService;

@RestController
@RequestMapping("/details")
public class PaymentReviewController {

	@Autowired
	PaymentReviewService paymentReviewService;

	@GetMapping("/id/{id}")
	public PaymentReview getPaymentReviewById(@PathVariable int id)
	{
		return paymentReviewService.getPaymentReviewById(id);
	}

	@PostMapping("/save")
	public void savePaymentReview(@RequestBody PaymentReview paymentReview)
	{
		paymentReviewService.savePaymentReview(paymentReview);
	}
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id)
	{
		paymentReviewService.delete(id);
	}
}
