package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Payment;

public interface PaymentDAL {

	Payment getById(int id);

	Payment save(Payment Payment);

	void delete(int id);

	void updateDescription(int id, String description);
}
