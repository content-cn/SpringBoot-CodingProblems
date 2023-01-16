package com.cn.cnpayment;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.entity.PaymentReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CnPaymentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CnPaymentApplication.class, args);
	}

	@Autowired
	PaymentDAL paymentDAL;

	@Override
	public void run(String... args) {

		for(Payment payment : paymentDAL.getAllPayments())
		{
			System.out.println(payment.toString());
		}
		System.out.println("=============");
		for(Payment payment : paymentDAL.getAllPaymentsByCurrency("rupee"))
		{
			System.out.println(payment.toString());
		}
		System.out.println("=============");
		for(PaymentReview paymentReview : paymentDAL.getPaymentReviews(7))
		{
			System.out.println(paymentReview.toString());
		}
		System.out.println("==1===========");
		for(Payment payment : paymentDAL.getAllPaymentsByQueryType("issue"))
		{
			System.out.println(payment.toString());
		}

	}
}
