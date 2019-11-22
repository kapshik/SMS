package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.ProductViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class ProductRestController {

	@Autowired
	private SmsViewService<ProductViewModel> service;
	
	@GetMapping("product/init")
	public ProductViewModel init() {
		ProductViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("product/search")
	public ProductViewModel search(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("product/delete")
	public ProductViewModel delete(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("product/customerChange")
	public ProductViewModel customerChange(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
