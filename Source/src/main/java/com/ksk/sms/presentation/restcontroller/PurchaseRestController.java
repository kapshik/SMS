package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.PurchaseViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class PurchaseRestController {

	@Autowired
	private SmsViewService<PurchaseViewModel> service;
	
	@GetMapping("purchase/init")
	public PurchaseViewModel init() {
		PurchaseViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("purchase/search")
	public PurchaseViewModel search(@RequestBody PurchaseViewModel inModel) {
		PurchaseViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("purchase/delete")
	public PurchaseViewModel delete(@RequestBody PurchaseViewModel inModel) {
		PurchaseViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("purchase/customerChange")
	public PurchaseViewModel customerChange(@RequestBody PurchaseViewModel inModel) {
		PurchaseViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
