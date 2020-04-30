package com.cms.sms.model;

import java.io.Serializable;
import java.util.List;

import com.cms.sms.common.KeyValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsViewModel implements Serializable{

	private static final long serialVersionUID = 1L;

	protected String username;
	protected String role;
	protected String title;

	protected List<KeyValue> branchList;
	protected List<KeyValue> customerList;
	protected List<KeyValue> deliveryDestList;
	protected List<KeyValue> productMasterList;
	protected List<KeyValue> paymentTermsList;
	protected List<KeyValue> productTypeList;
	protected List<KeyValue> unitTypeList;

}

