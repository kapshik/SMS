package com.ksk.sms.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDataCriteria implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String customerName;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String telNo;
	private String faxNo;
	private String srartDate;
	private String paymentTerms;
}

