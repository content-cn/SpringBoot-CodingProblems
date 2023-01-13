package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.Payment;

@Repository
public class PaymentDALImpl implements PaymentDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, id);
		return payment;
	}

	@Override
	public void save(Payment payment) {
		Session session = entityManager.unwrap(Session.class);
		session.save(payment);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, id);
		session.delete(payment);
		
	}

	@Override
	public void updateDescription(int paymentId,String description) {
		Session session = entityManager.unwrap(Session.class);
		//fetch the current payment details from the DB
		Payment currentPayment = session.get(Payment.class, paymentId);
		//update the details in the current object
		currentPayment.setDescription(description);
		//update the database
		session.update(currentPayment);

	}
	
}
