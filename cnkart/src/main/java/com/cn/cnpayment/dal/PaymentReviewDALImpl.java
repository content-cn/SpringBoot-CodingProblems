package com.cn.cnpayment.dal;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cn.cnpayment.entity.PaymentReview;

@Repository
public class PaymentReviewDALImpl implements PaymentReviewDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(PaymentReview review) {
		Session session = entityManager.unwrap(Session.class);
		session.save(review);
	}

}
