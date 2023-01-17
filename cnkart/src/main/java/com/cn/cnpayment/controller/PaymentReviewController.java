package com.cn.cnpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.service.PaymentReviewService;

@RestController
@RequestMapping("/review")
public class PaymentReviewController {

	@Autowired
	PaymentReviewService paymentReviewService;
	
	@PostMapping("/save")
	public void save(@RequestBody PaymentReview review)
	{
		paymentReviewService.savePaymentReview(review);
	}


}
