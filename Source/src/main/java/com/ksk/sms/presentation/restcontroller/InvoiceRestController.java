package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.InvoiceViewModel;
import com.ksk.sms.service.view.InvoiceService;

@RestController
public class InvoiceRestController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping("invoice/init")
	public InvoiceViewModel init() {
		InvoiceViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("invoice/search")
	public InvoiceViewModel search(@RequestBody InvoiceViewModel inModel) {
		InvoiceViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("invoice/delete")
	public InvoiceViewModel delete(@RequestBody InvoiceViewModel inModel) {
		InvoiceViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("invoice/customerChange")
	public InvoiceViewModel customerChange(@RequestBody InvoiceViewModel inModel) {
		InvoiceViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
