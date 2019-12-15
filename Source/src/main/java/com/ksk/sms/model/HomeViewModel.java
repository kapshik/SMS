package com.ksk.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeViewModel extends SmsViewModel{

	private List<BranchModel> branchModelList;
	private List<CustomerModel> customerModelList;
	private List<DeliveryDestModel> deliveryDestModelList;
	private List<OrderModel> orderModelList;
	private List<ProductModel> productModelList;
	private List<StockModel> stockModelList;

}

