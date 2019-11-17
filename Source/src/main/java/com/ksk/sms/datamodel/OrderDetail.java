package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String branchNo;
	private String deliveryDestNo;
	private String orderNo;
	private String shippingLabelNo;
	private String orderDate;
	private String shippingDate;
	private String deliveryDate;
	private String quantity;
	private String unitPrice;
	private String discountUnitPrice;
	private String memo;
	
	private BranchData branchData;
	private CustomerData customerData;
	private DeliveryDestData deliveryDestData;
	
	private List<ProductData> productList;

}

