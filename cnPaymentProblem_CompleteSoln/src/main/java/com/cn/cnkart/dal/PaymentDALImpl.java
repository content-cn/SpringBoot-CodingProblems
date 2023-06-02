package com.cn.cnkart.dal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnkart.entity.Payment;

@Repository
public class PaymentDALImpl implements PaymentDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment Payment = session.get(Payment.class, id);
		return Payment;
	}

	@Override
	public Payment save(Payment Payment) {
		Session session = entityManager.unwrap(Session.class);
		session.save(Payment);
		return Payment;
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment Payment = session.get(Payment.class, id);
		session.delete(Payment);
		
	}

	@Override
	public void updateDescription(int paymentId,String description) {
		Session session = entityManager.unwrap(Session.class);
		//fetch the current Payment details from the DB
		Payment currentPayment = session.get(Payment.class, paymentId);
		//update the details in the current object
		currentPayment.setDescription(description);
		//update the database
		session.update(currentPayment);
		
	}
	
}
