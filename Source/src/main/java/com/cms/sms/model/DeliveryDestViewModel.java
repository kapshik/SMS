package com.cms.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDestViewModel extends SmsViewModel{

	private DeliveryDestModel criteria;
	private DeliveryDestModel detail;
	
	private BranchModel branchModel;
	private CustomerModel customerModel;
	private DeliveryDestModel deliveryDestModel;
	private ProductModel productModel;

	private List<BranchModel> branchModelList;
	private List<DeliveryDestModel> deliveryDestModelList;
	private List<ProductModel> productModelList;

}

