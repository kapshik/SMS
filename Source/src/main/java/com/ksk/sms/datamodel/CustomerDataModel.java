package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;

	private CustomerDataCriteria customerDataCriteria;
	private List<CustomerData> customerDataList;

}

