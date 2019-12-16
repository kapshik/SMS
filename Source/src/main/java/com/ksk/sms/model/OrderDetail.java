package com.ksk.sms.model;

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
	private String customerName;
	private String branchName;
	private String deliveryDestName;
	private String orderNo;
	private String shippingLabelNo;
	private String orderDate;
	private String shippingDate;
	private String deliveryDate;
	private String quantity;
	private String unitPrice;
	private String discountUnitPrice;
	private String memo;
	
	private BranchModel branchModel;
	private CustomerModel customerModel;
	private DeliveryDestModel deliveryDestModel;
	
	private List<ProductModel> productList;

}

