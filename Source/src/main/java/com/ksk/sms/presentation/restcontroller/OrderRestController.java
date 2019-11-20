package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.OrderViewModel;
import com.ksk.sms.service.view.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService service;
	
	@GetMapping("order/init")
	public OrderViewModel init() {
		OrderViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("order/search")
	public OrderViewModel search(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/delete")
	public OrderViewModel delete(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/customerChange")
	public OrderViewModel customerChange(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
