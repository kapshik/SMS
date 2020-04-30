package com.cms.sms.presentation.restcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.sms.model.HomeViewModel;
import com.cms.sms.model.OrderModel;
import com.cms.sms.service.common.impl.SmsUserDetails;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class HomeRestController {

	@GetMapping("home/init")	
	public HomeViewModel init(@AuthenticationPrincipal SmsUserDetails inUserDetail) {
		HomeViewModel model = new HomeViewModel();
		model.setOrderModelList(makeList());
		model.setUsername(inUserDetail.getUsername());

		log.info("SmsUserDetails " + inUserDetail.getUsername());
		
		return model;
	}
	
	private List<OrderModel> makeList() {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		
		for(int i=0; i<10; i++) {
			String strNo = Integer.toString(i);
			OrderModel orderData = new OrderModel();

			orderData.setCustomerNo("Customer"+strNo);
			orderData.setBranchNo("Branch"+strNo);
			orderData.setDeliveryDestNo("DeliveryDest"+strNo);
			orderData.setOrderNo(strNo);
			orderData.setShippingLabelNo("ShippingLabel"+strNo);
			orderData.setOrderDate(LocalDate.now());
			orderData.setShippingDate(LocalDate.now());
			orderData.setDeliveryDate(LocalDate.now());
			orderData.setQuantity(i);
			orderData.setUnitPrice(i);
			orderData.setDiscountUnitPrice(i);
			orderData.setMemo("Memo"+strNo);
			
			orderList.add(orderData);
		}

		return orderList;
		
	}
}
