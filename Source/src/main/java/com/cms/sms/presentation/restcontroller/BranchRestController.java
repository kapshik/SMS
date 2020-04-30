package com.cms.sms.presentation.restcontroller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.sms.model.BranchViewModel;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class BranchRestController {

	@Autowired
	HttpSession session;  
	@Autowired
	private SmsViewService<BranchViewModel> service;
	
	@GetMapping("branch/init")
	public BranchViewModel init() {
		BranchViewModel outModel = service.init();
		
		return outModel;
	}
	
	@GetMapping("branch/init_detail")
	public BranchViewModel init_detail() {
		BranchViewModel outModel = service.detail((BranchViewModel)session.getAttribute("branchViewModel"));
log.info("branch/init_detail");
		return outModel;
	}
	
	@PostMapping("branch/search")
	public BranchViewModel search(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("branch/create")
	public BranchViewModel create(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.create(inModel);
		session.setAttribute("branchViewModel", outModel);
		
		return outModel;
	}
	
	@PostMapping("branch/detail")
	public BranchViewModel detail(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = Objects.requireNonNull(inModel);
		session.setAttribute("branchViewModel", outModel);

		return outModel;
	}
	
	@PostMapping("branch/delete")
	public BranchViewModel delete(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("branch/branchChange")
	public BranchViewModel branchChange(@RequestBody BranchViewModel inModel) {
		BranchViewModel outModel = service.branchChange(inModel);
		
		return outModel;
	}
	
}
