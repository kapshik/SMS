package com.ksk.sms.model.base;

import java.io.Serializable;

public class OrderDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDeliveryDestination() {
		return deliveryDestination;
	}
	public void setDeliveryDestination(String deliveryDestination) {
		this.deliveryDestination = deliveryDestination;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	private String orderNo;
	private String customer;
	private String branchName;
	private String deliveryDestination;
	private String orderDate;
	private String deliveryDate;
	private String shippingDate;
	private String creationDate;
}

