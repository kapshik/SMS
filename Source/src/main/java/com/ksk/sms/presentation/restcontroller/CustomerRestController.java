package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.CustomerViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class CustomerRestController {

	@Autowired
	private SmsViewService<CustomerViewModel> service;
	
	@GetMapping("customer/init")
	public CustomerViewModel init() {
		CustomerViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("customer/search")
	public CustomerViewModel search(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("customer/create")
	public CustomerViewModel create(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("customer/delete")
	public CustomerViewModel delete(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("customer/customerChange")
	public CustomerViewModel customerChange(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.customerChange(inModel);
		
		return outModel;
	}
	
}
