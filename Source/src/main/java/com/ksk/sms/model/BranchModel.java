package com.ksk.sms.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String branchNo;
	private String branchName;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String telNo;
	private String faxNo;
}

