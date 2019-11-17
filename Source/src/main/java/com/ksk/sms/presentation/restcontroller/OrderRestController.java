package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.datamodel.OrderDataModel;
import com.ksk.sms.service.view.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("order/init")
	public OrderDataModel init() {
		OrderDataModel outModel = orderService.init();
		
		return outModel;
	}
	
	@PostMapping("order/search")
	public OrderDataModel search(@RequestBody OrderDataModel inModel) {
		OrderDataModel outModel = orderService.search(inModel);
		
		return outModel;
	}
	
}
