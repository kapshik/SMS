package com.ksk.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerViewModel extends SmsViewModel{

	private CustomerModel criteria;
	private CustomerModel detail;
	
	private BranchModel branchModel;
	private CustomerModel customerModel;
	private DeliveryDestModel deliveryDestModel;
	private ProductModel productModel;

	private List<CustomerModel> customerModelList;
	private List<BranchModel> branchModelList;
	private List<ProductModel> productModelList;

	private List<ValidationErrorModel> validationErrorList;
}
