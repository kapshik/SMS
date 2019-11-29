package com.ksk.sms.presentation.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ksk.sms.model.InvoiceViewModel;
import com.ksk.sms.service.report.InvoiceReportService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;

@Log4j2
@RestController
public class InvoiceRestController {

	@Autowired
	private SmsViewService<InvoiceViewModel> service;
	
	@Autowired
	private InvoiceReportService reportService;
	
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
	
	@PostMapping("invoice/download")
	public void download(ModelAndView model, HttpServletResponse response) throws IOException, JRException {

		reportService.mekeInvoice(response, "attachment");
		log.info("attachment");

	}

	@PostMapping("invoice/display")
	public void display(ModelAndView model, HttpServletResponse response) throws IOException, JRException {
		
		reportService.mekeInvoice(response, "inline");
		log.info("inline");

	}
}
