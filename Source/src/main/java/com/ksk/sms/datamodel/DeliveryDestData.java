package com.ksk.sms.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDestData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String branchNo;
	private String deliveryDestNo;
	private String deliveryDestName;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String telNo;
	private String faxNo;
}

