package com.cn.cnkart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.PaymentDAL;
import com.cn.cnkart.entity.Payment;

@Service
public class PaymentService {

	@Autowired
	PaymentDAL PaymentDAL;
	
	@Transactional
	public Payment getPaymentById(int id) {
		return PaymentDAL.getById(id);
	}

	@Transactional
	public Payment savePayment(Payment Payment) {
		
		return PaymentDAL.save(Payment);
	}

	@Transactional
	public void delete(int id) {
		PaymentDAL.delete(id);
		
	}

	@Transactional
	public void updateDescription(int id, String description) {
	
		PaymentDAL.updateDescription(id,description);
	}
	
}
