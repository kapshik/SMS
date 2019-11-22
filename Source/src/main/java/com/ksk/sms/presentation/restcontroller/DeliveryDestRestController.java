package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.BranchViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class DeliveryDestRestController {

	@Autowired
	private SmsViewService<BranchViewModel> service;
	
	@GetMapping("/deliverydest/init")
	public BranchViewModel init() {
		BranchViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("deliverydest/search")
	public BranchViewModel search(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/create")
	public BranchViewModel create(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/add")
	public BranchViewModel update(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.update(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/delete")
	public BranchViewModel delete(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.delete(inModel);
		
		return outModel;
	}
	
}
