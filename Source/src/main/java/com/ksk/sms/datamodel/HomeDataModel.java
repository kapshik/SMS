package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	private List<BranchData> branchDataList;
	private List<CustomerData> customerDataList;
	private List<DeliveryDestData> deliveryDestDataList;
	private List<EstimationData> estimationDataList;
	private List<InvoiceData> invoiceDataList;
	private List<OrderData> orderDataList;
	private List<ProductData> productDataList;
	private List<StockData> stockDataList;

}

