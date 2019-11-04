package com.ksk.sms.model.report;

import java.util.ArrayList;
import java.util.List;

import com.ksk.sms.model.base.MainmenuDataModel;
import com.ksk.sms.model.base.OrderDataModel;

public class TestReportDataFactory {

	public MainmenuDataModel mainMenuInit() {
		MainmenuDataModel mainmenuDataModel = new MainmenuDataModel();
		mainmenuDataModel.setUser("user kapshik");
		mainmenuDataModel.setPassword("教えない！！");
		mainmenuDataModel.setOrderList(makeList());
		
		return mainmenuDataModel;
	}
	
	public List<OrderDataModel> makeList() {
		List<OrderDataModel> orderList = new ArrayList<OrderDataModel>();
		
		for(int i=0; i<10; i++) {
			String strNo = Integer.toString(i);
			OrderDataModel orderDataModel = new OrderDataModel();

			orderDataModel.setOrderNo(strNo);
			orderDataModel.setCustomer("Customer"+strNo);
			orderDataModel.setBranchName("BranchName"+strNo);
			orderDataModel.setDeliveryDestination("DeliveryDestination"+strNo);
			orderDataModel.setOrderDate("OrderDate"+strNo);
			orderDataModel.setDeliveryDate("DeliveryDate"+strNo);
			orderDataModel.setShippingDate("ShippingDate"+strNo);
			orderDataModel.setCreationDate("CreationDate"+strNo);
			
			orderList.add(orderDataModel);
		}

		return orderList;
		
	}
}
