package com.ksk.sms.model.base;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderNo;
	private String customer;
	private String branchName;
	private String deliveryDestination;
	private String orderDate;
	private String deliveryDate;
	private String shippingDate;
	private String creationDate;
}

