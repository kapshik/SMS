package com.cms.sms.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZipCloudModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String status;
	private String message;
	private List<AddressModel> results;
}
