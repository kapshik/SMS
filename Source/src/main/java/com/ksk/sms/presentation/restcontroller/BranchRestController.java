package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.BranchViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class BranchRestController {

	@Autowired
	private SmsViewService<BranchViewModel> service;
	
	@GetMapping("branch/init")
	public BranchViewModel init() {
		BranchViewModel outModel = service.init();
		
		return outModel;
	}
	
	@PostMapping("branch/search")
	public BranchViewModel search(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("branch/delete")
	public BranchViewModel delete(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("branch/branchChange")
	public BranchViewModel BranchChange(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
