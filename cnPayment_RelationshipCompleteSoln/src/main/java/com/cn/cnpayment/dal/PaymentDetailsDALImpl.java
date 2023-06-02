package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;
import com.cn.cnpayment.entity.PaymentDetails;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public PaymentDetails getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		return paymentDetails;
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> allPaymentDetails= session.createQuery(
				"SELECT p FROM PaymentDetails p", PaymentDetails.class).getResultList();
		return allPaymentDetails;
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		session.delete(paymentDetails);
	}
}
