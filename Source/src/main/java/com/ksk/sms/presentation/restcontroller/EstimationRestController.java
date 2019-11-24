package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.EstimationViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class EstimationRestController {

	@Autowired
	private SmsViewService<EstimationViewModel> service;
	
	@GetMapping("estimation/init")
	public EstimationViewModel init() {
		EstimationViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("estimation/search")
	public EstimationViewModel search(@RequestBody EstimationViewModel inModel) {
		EstimationViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("estimation/delete")
	public EstimationViewModel delete(@RequestBody EstimationViewModel inModel) {
		EstimationViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("estimation/customerChange")
	public EstimationViewModel customerChange(@RequestBody EstimationViewModel inModel) {
		EstimationViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
