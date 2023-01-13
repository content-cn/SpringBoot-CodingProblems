package com.cn.cnpayment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;

@Service
public class PaymentService {

	@Autowired
    PaymentDAL paymentDAL;
	
	@Transactional
	public Payment getPaymentById(int id) {
		return paymentDAL.getById(id);
	}

	@Transactional
	public void savePayment(Payment payment) {
		
		paymentDAL.save(payment);
	}

	@Transactional
	public void delete(int id) {
		paymentDAL.delete(id);
		
	}

	@Transactional
	public void updateDescription(int id, String description) {

		paymentDAL.updateDescription(id,description);
	}
	
}
