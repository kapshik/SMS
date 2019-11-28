package com.ksk.sms.presentation.restcontroller;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.InvoiceViewModel;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class InvoiceRestController {

	@Autowired
	private SmsViewService<InvoiceViewModel> service;
	
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
	
	@RequestMapping("invoice/download")
	@Produces({MediaType.APPLICATION_PDF_VALUE})
	public Resource download(Model inModel) {
		log.info("./reportOut/Invoice_2019-11-28.pdf");
		return new FileSystemResource("./reportOut/Invoice_2019-11-28.pdf");
	}
	
}
