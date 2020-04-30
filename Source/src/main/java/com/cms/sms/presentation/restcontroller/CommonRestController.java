package com.cms.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.sms.model.AddressModel;
import com.cms.sms.model.CustomerViewModel;
import com.cms.sms.service.common.SmsAddressService;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CommonRestController {

	@Autowired
	private SmsAddressService smsAddressService;
	
	@GetMapping("common/search_address")
	public AddressModel search_address(@RequestParam("zipcode") String zipcode) {
		
	    return smsAddressService.getAddressModelByObject(zipcode);
	    
	}
	
}
