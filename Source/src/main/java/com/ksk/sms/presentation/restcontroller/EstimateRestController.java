package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.EstimateViewModel;
import com.ksk.sms.service.view.EstimateService;

@RestController
public class EstimateRestController {

	@Autowired
	private EstimateService service;
	
	@GetMapping("estimate/init")
	public EstimateViewModel init() {
		EstimateViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("estimate/search")
	public EstimateViewModel search(@RequestBody EstimateViewModel inModel) {
		EstimateViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("estimate/delete")
	public EstimateViewModel delete(@RequestBody EstimateViewModel inModel) {
		EstimateViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("estimate/customerChange")
	public EstimateViewModel customerChange(@RequestBody EstimateViewModel inModel) {
		EstimateViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
