package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Payment;

public interface PaymentDAL {

	Payment getById(int id);

	void save(Payment payment);

	void delete(int id);

	void updateDescription(int id, String description);

}
