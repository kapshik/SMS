package com.ksk.sms.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderNo;
	private String customerNo;
	private String customerName;
	private String branchName;
	private String deliveryDestName;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String telNo;
	private String faxNo;
	@JsonFormat(pattern="yyyy/MM/dd")
	private LocalDate startDate;
	private String paymentTerms;
	private String paymentTermsName;
}

