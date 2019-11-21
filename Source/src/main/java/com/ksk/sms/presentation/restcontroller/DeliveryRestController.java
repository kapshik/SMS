package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.DeliveryViewModel;
import com.ksk.sms.service.view.DeliveryService;

@RestController
public class DeliveryRestController {

	@Autowired
	private DeliveryService service;
	
	@GetMapping("delivery/init")
	public DeliveryViewModel init() {
		DeliveryViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("delivery/search")
	public DeliveryViewModel search(@RequestBody DeliveryViewModel inModel) {
		DeliveryViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("delivery/delete")
	public DeliveryViewModel delete(@RequestBody DeliveryViewModel inModel) {
		DeliveryViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("delivery/customerChange")
	public DeliveryViewModel customerChange(@RequestBody DeliveryViewModel inModel) {
		DeliveryViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
