package com.cn.cnkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CnkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnkartApplication.class, args);
	}

}
