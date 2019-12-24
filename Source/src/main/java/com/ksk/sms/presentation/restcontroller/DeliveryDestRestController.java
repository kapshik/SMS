package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.DeliveryDestViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class DeliveryDestRestController {

	@Autowired
	private SmsViewService<DeliveryDestViewModel> service;
	
	@GetMapping("/deliverydest/init")
	public DeliveryDestViewModel init() {
		DeliveryDestViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("deliverydest/search")
	public DeliveryDestViewModel search(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/create")
	public DeliveryDestViewModel create(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/add")
	public DeliveryDestViewModel update(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.update(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/delete")
	public DeliveryDestViewModel delete(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.delete(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/customerChange")
	public DeliveryDestViewModel customerChange(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.customerChange(inModel);
		
		return outModel;
	}
}
