package com.cn.cnkart.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String paymentType;
	@Column
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;
	
	@OneToMany(mappedBy= "payment",cascade = CascadeType.ALL)	
	private List<PaymentReview> paymentReview;

	@ManyToMany(mappedBy = "payments")
	Set<Order> paymentOrders;

	public List<PaymentReview> getPaymentReview() {
		return paymentReview;
	}
	public void setPaymentReview(List<PaymentReview> paymentReview) {
		this.paymentReview = paymentReview;
	}

	public Set<Order> getPaymentOrders() {
		return paymentOrders;
	}

	public void setPaymentOrders(Set<Order> paymentOrders) {
		this.paymentOrders = paymentOrders;
	}

	public int getId() {
		return id;
	}
	public String getPaymentType() {return paymentType;}
	public void setPaymentType(String paymentType) {this.paymentType = paymentType;}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
}
