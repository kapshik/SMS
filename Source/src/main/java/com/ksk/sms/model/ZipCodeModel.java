package com.ksk.sms.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZipCodeModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String zipCode;
	private String address;
	private String addressDetail;
}

