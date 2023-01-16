package com.cn.cnpayment;

import com.cn.cnpayment.service.PaymentService;
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
	PaymentService paymentService;

	@Override
	public void run(String... args) {
		{
			paymentService.getPaymentById(14);

		}
	}
};
