package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.datamodel.BranchDataModel;
import com.ksk.sms.service.view.BranchService;

@RestController
public class BranchRestController {

	@Autowired
	private BranchService branchService;
	
	@GetMapping("branch/init")
	public BranchDataModel init() {
		BranchDataModel outModel = branchService.init();
		
		return outModel;
	}
	
	@PostMapping("branch/search")
	public BranchDataModel search(@RequestBody BranchDataModel inModel) {
		BranchDataModel outModel = branchService.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("branch/branchChange")
	public BranchDataModel BranchChange(@RequestBody BranchDataModel inModel) {
		BranchDataModel outModel = branchService.search(inModel);
		
		return outModel;
	}
	
}
