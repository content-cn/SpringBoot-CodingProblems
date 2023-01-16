package com.cn.cnpayment.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;

@Service
public class PaymentReviewService {

	@Autowired
	PaymentReviewDAL paymentReviewDAL;
	
	@Transactional
	public void save(PaymentReview review) {
		paymentReviewDAL.save(review);
		
	}
}
