package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import com.ksk.sms.common.KeyValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;

	private CustomerCriteria customerCriteria;
	private CustomerData customerDetail;
	
	private BranchData branchData;
	private CustomerData customerData;
	private DeliveryDestData deliveryDestData;
	private ProductData productData;

	private List<CustomerData> customerDataList;
	private List<ProductData> productDataList;

	private List<KeyValue> branchList;
	private List<KeyValue> customerList;
	private List<KeyValue> deliveryDestList;
	private List<KeyValue> productMasterList;
	private List<KeyValue> paymentTermsList;
}

