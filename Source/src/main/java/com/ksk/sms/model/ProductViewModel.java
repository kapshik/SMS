package com.ksk.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewModel extends SmsViewModel{

	private ProductModel criteria;
	private ProductModel detail;
	private OrderModel orderDetail;
	
	private BranchModel branchModel;
	private CustomerModel customerModel;
	private DeliveryDestModel deliveryDestModel;
	private ProductModel productModel;
	
	private List<OrderModel> orderModelList;
	private List<ProductModel> productModelList;

}

