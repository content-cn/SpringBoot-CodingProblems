package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.Payment;

import java.lang.reflect.Type;
import java.util.List;

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
	public List<Payment> getByPaymentType(String paymentType){
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Payment> query = session.createQuery(
				"SELECT p FROM Payment p WHERE p.paymentType = ?1", Payment.class);
		List<Payment> payment = query.setParameter(1, paymentType).getResultList();

		return payment;
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword){
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Payment> query = session.createQuery(
				"SELECT p FROM Payment p WHERE p.description LIKE ?1", Payment.class);
		List<Payment> payment = query.setParameter(1,"%"+ keyword+"%").getResultList();

		return payment;
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
	public void update(Payment updatePayment) {
		Session session = entityManager.unwrap(Session.class);
		//fetch the current payment details from the DB
		Payment currentPayment = session.get(Payment.class, updatePayment.getId());
		//update the details in the current object
		currentPayment.setDescription(updatePayment.getDescription());
		currentPayment.setPaymentType(updatePayment.getPaymentType());
		//update the database
		session.update(currentPayment);

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
