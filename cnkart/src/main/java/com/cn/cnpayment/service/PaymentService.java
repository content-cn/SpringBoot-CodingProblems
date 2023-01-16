package com.cn.cnpayment.service;

import javax.transaction.Transactional;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.PaymentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;

import java.util.List;

@Service
public class PaymentService {

	@Autowired
	PaymentDAL paymentDAL;

	@Transactional
	public Payment getPaymentById(int id) {
		return paymentDAL.getById(id);
	}

	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {

		return paymentDAL.getByPaymentType(paymentType);
	}

	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {

		return paymentDAL.getByPaymentDescription(keyword);
	}

	@Transactional
	public Payment savePayment(Payment Payment) {

		return paymentDAL.save(Payment);
	}

	@Transactional
	public void delete(int id) {
		paymentDAL.delete(id);

	}

	@Transactional
	public void update(Payment updatePayment) {

		paymentDAL.update(updatePayment);
	}

	@Transactional
	public void updateDescription(int id, String description) {

		paymentDAL.updateDescription(id,description);
	}

	public List<Payment> getAllPaymentsByCurrency(String currency) {

		return paymentDAL.getAllPaymentsByCurrency(currency);
	}

	public List<Payment> getAllPaymentsByQueryType(String queryType) {

		return paymentDAL.getAllPaymentsByQueryType(queryType);
	}

	public List<Payment> getAllPayments() {

		return paymentDAL.getAllPayments();
	}

	public List<PaymentReview> getPaymentReviews(int paymentId) {

		return paymentDAL.getPaymentReviews(paymentId);
	}

}
