package com.cn.cnpayment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment_review")
public class PaymentReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private int id;
	
	@Column
	public String queryPersonName;
	
	@Column
	public String queryType;

	@Column
	public String queryDescription;

	@ManyToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public String getQueryPersonName() {
		return queryPersonName;
	}

	public void setQueryPersonName(String queryPersonName) {
		this.queryPersonName = queryPersonName;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	@Override
	public String toString() {
		return "PaymentReview{" +
				", queryPersonName='" + queryPersonName + '\'' +
				", queryType='" + queryType + '\'' +
				", queryDescription='" + queryDescription + '\'' +
				'}';
	}
}
