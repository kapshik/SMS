package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.ReportViewModel;
import com.ksk.sms.service.view.SmsViewService;

@RestController
public class ReportRestController {

	@Autowired
	private SmsViewService<ReportViewModel> service;
	
	@GetMapping("report/init")
	public ReportViewModel init() {
		ReportViewModel outModel = service.init();
		
		return outModel;
	}
	
}
