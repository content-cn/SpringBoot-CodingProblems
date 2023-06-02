package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;

import java.util.List;

public interface PaymentDAL {

	Payment getById(int id);

	Payment save(Payment Payment);

	void delete(int paymentId);

	void update(Payment updatePayment);

	void updateDescription(int id, String description);

	List<Payment> getAllPayments();

	List<Payment> getByPaymentType(String paymentType);

	List<Payment> getByPaymentDescription(String keyword);

	List<Payment> getAllPaymentsByCurrency(String currency);
}
