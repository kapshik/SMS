package com.ksk.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderViewModel extends SmsViewModel{

	private OrderModel criteria;

	private OrderModel orderModel;
	private BranchModel branchModel;
	private CustomerModel customerModel;
	private DeliveryDestModel deliveryDestModel;
	private ProductModel productModel;
	
	private List<OrderModel> orderModelList;
	private List<ProductModel> productModelList;

}

