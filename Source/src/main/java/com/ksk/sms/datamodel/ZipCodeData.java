package com.ksk.sms.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZipCodeData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String zipCode;
	private String address;
	private String addressDetail;
}

