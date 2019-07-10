package com.crm.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Orders database table.
 * 
 */
@Entity
@Table(name="Orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderId")
	private int orderId;

	@Column(name="PaymentMethod")
	private Object paymentMethod;

	@Column(name="ProductList")
	private Object productList;

	@Column(name="Status")
	private Object status;

	@Column(name="TotalAmount")
	private Object totalAmount;

    public Order() {
    }

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Object getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(Object paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Object getProductList() {
		return this.productList;
	}

	public void setProductList(Object productList) {
		this.productList = productList;
	}

	public Object getStatus() {
		return this.status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public Object getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Object totalAmount) {
		this.totalAmount = totalAmount;
	}

}