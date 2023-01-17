package com.cn.cnpayment.service;

import javax.transaction.Transactional;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import java.util.List;

@Service
public class PaymentReviewService {

	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		PaymentReview paymentReview=paymentReviewDAL.getById(id);
		if(paymentReview==null)
		{
			throw new NotFoundException("No paymentReview found with id:  "+id);
		}
		return paymentReview;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		List<PaymentReview> paymentReview = paymentReviewDAL.getAllPaymentReview();
		if(paymentReview==null)
		{
			throw new NotFoundException("No paymentReviews found.");
		}
		return paymentReview;
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {
		List<PaymentReview> allPaymentReview = getAllPaymentReviews();
		for(PaymentReview paymentReview : allPaymentReview)
		{
			if(paymentReview.getId()==newPaymentReview.getId())
			{
				throw new ElementAlreadyExistException("This paymentReview already exist.");
			}
		}
		paymentReviewDAL.save(newPaymentReview);
	}

	@Transactional
	public void delete(int id) {
		paymentReviewDAL.delete(id);
	}

}
