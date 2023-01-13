package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;

public interface PaymentDAL {

	Payment getById(int id);

	void save(Payment payment);

	void delete(int id);

	void updateDescription(int id, String description);

}
