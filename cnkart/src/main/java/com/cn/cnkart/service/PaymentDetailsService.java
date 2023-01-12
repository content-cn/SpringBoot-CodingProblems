package com.cn.cnkart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.PaymentDetailsDAL;

@Service
public class PaymentDetailsService {

	@Autowired
    PaymentDetailsDAL paymentDetailsDAL;
	
	@Transactional
	public void delete(int id) {
		
		paymentDetailsDAL.delete(id);
	}


}
