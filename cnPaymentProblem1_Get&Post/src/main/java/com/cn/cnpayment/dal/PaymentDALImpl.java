package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;

import com.cn.cnpayment.service.PaymentService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDALImpl implements PaymentDAL{

	@Autowired
	EntityManager entityManager;

	@Autowired
	PaymentService paymentService;

	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, id);
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		Session session = entityManager.unwrap(Session.class);
		List<Payment> allPayments= session.createQuery(
				"SELECT p FROM Payment p", Payment.class).getResultList();
		return allPayments;
	}

	@Override
	public List<Payment> getByPaymentType(String paymentType){
		List<Payment> allPayments=paymentService.getAllPayments();
		List<Payment> paymentsByPaymentType = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getPaymentType().equalsIgnoreCase(paymentType))
			{
				paymentsByPaymentType.add(payment);
			}
		}
		return paymentsByPaymentType;
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword){
		List<Payment> allPayments=paymentService.getAllPayments();
		List<Payment> paymentsByDescription = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getDescription().contains(keyword))
			{
				paymentsByDescription.add(payment);
			}
		}
		return paymentsByDescription;
	}
}
