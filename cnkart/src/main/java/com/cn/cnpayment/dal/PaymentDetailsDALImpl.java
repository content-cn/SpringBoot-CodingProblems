package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.PaymentDetails;

@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		session.delete(paymentDetails);
	}


}
