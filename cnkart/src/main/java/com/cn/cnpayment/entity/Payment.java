package com.cn.cnpayment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private int id;

	@Column
	private String paymentType;

	@Column
	private String description;

	public int getId() {
		return id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", paymentType='" + paymentType + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
