package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.AddressModel;
import com.ksk.sms.model.CustomerViewModel;
import com.ksk.sms.service.common.SmsAddressService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CustomerRestController {

	@Autowired
	private SmsViewService<CustomerViewModel> service;
	@Autowired
	private SmsAddressService smsAddressService;
	
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
	
	@GetMapping("customer/search_address")
	public AddressModel search_address(@RequestParam("zipcode") String zipcode) {
		
	    return smsAddressService.getAddressModelByObject(zipcode);
	    
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
