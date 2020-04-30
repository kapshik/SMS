package com.cms.sms.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String address1;
	private String address2;
	private String address3;
	private String kana1;
	private String kana2;
	private String kana3;
	private String prefcode;
	private String zipcode;
}
