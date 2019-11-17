package com.ksk.sms.presentation.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.datamodel.HomeDataModel;
import com.ksk.sms.datamodel.OrderData;

@RestController
public class HomeRestController {

	@GetMapping("home/init")	
	public HomeDataModel mainMenuInit() {
		HomeDataModel homeDataModel = new HomeDataModel();
		homeDataModel.setUserName("user kapshik");
		homeDataModel.setPassword("教えない！！");
		homeDataModel.setOrderDataList(makeList());
		
		return homeDataModel;
	}
	
	private List<OrderData> makeList() {
		List<OrderData> orderList = new ArrayList<OrderData>();
		
		for(int i=0; i<10; i++) {
			String strNo = Integer.toString(i);
			OrderData orderData = new OrderData();

			orderData.setCustomerNo("Customer"+strNo);
			orderData.setBranchNo("Branch"+strNo);
			orderData.setDeliveryDestNo("DeliveryDest"+strNo);
			orderData.setOrderNo(strNo);
			orderData.setShippingLabelNo("ShippingLabel"+strNo);
			orderData.setOrderDate("OrderDate"+strNo);
			orderData.setShippingDate("ShippingDate"+strNo);
			orderData.setDeliveryDate("DeliveryDate"+strNo);
			orderData.setQuantity("Quantity"+strNo);
			orderData.setUnitPrice("UnitPrice"+strNo);
			orderData.setDiscountUnitPrice("DiscountUnitPrice"+strNo);
			orderData.setMemo("Memo"+strNo);
			
			orderList.add(orderData);
		}

		return orderList;
		
	}
}
