package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.StockViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class StockRestController {

	@Autowired
	private SmsViewService<StockViewModel> service;
	
	@GetMapping("stock/init")
	public StockViewModel init() {
		StockViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("stock/search")
	public StockViewModel search(@RequestBody StockViewModel inModel) {
		StockViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("stock/delete")
	public StockViewModel delete(@RequestBody StockViewModel inModel) {
		StockViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("stock/customerChange")
	public StockViewModel customerChange(@RequestBody StockViewModel inModel) {
		StockViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
