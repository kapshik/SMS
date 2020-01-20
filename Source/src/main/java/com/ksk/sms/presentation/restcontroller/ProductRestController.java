package com.ksk.sms.presentation.restcontroller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.ProductViewModel;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class ProductRestController {

	@Autowired
	HttpSession session;  
	@Autowired
	private SmsViewService<ProductViewModel> service;
	
	@GetMapping("product/init")
	public ProductViewModel init() {
		ProductViewModel outModel = service.init();
		
		return outModel;
	}
	
	@GetMapping("product/init_detail")
	public ProductViewModel init_detail() {
		ProductViewModel outModel = service.detail((ProductViewModel)session.getAttribute("productViewModel"));
log.info("product/init_detail");
		return outModel;
	}
	
	@PostMapping("product/search")
	public ProductViewModel search(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("product/create")
	public ProductViewModel create(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("product/detail")
	public ProductViewModel detail(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = Objects.requireNonNull(inModel);
		session.setAttribute("productViewModel", outModel);

		return outModel;
	}
	
	@PostMapping("product/delete")
	public ProductViewModel delete(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("product/customerChange")
	public ProductViewModel customerChange(@RequestBody ProductViewModel inModel) {
		ProductViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
}
