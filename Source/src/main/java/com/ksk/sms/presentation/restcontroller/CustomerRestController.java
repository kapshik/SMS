package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.datamodel.CustomerDataModel;
import com.ksk.sms.service.view.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("customer/init")
	public CustomerDataModel init() {
		CustomerDataModel outModel = customerService.init();
		
		return outModel;
	}
	
	@PostMapping("customer/search")
	public CustomerDataModel search(@RequestBody CustomerDataModel inModel) {
		CustomerDataModel outModel = customerService.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("customer/customerChange")
	public CustomerDataModel customerChange(@RequestBody CustomerDataModel inModel) {
		CustomerDataModel outModel = customerService.search(inModel);
		
		return outModel;
	}
	
}
