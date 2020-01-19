package com.ksk.sms.presentation.restcontroller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksk.sms.model.DeliveryDestViewModel;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class DeliveryDestRestController {

	@Autowired
	HttpSession session;  
	@Autowired
	private SmsViewService<DeliveryDestViewModel> service;
	
	@GetMapping("/deliverydest/init")
	public DeliveryDestViewModel init() {
		DeliveryDestViewModel outModel = service.init();
		
		return outModel;
	}
	
	@GetMapping("deliverydest/init_detail")
	public DeliveryDestViewModel init_detail() {
		DeliveryDestViewModel outModel = service.detail((DeliveryDestViewModel)session.getAttribute("deliveryDestViewModel"));
log.info("deliverydest/init_detail");
		return outModel;
	}
	
	@PostMapping("deliverydest/search")
	public DeliveryDestViewModel search(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/create")
	public DeliveryDestViewModel create(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/add")
	public DeliveryDestViewModel update(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.update(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/detail")
	public DeliveryDestViewModel detail(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);
		session.setAttribute("deliveryDestViewModel", outModel);

		return outModel;
	}
	
	@PostMapping("deliverydest/delete")
	public DeliveryDestViewModel delete(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.delete(inModel);
		
		return outModel;
	}
	
	@PostMapping("deliverydest/customerChange")
	public DeliveryDestViewModel customerChange(@RequestBody DeliveryDestViewModel inModel) {
		DeliveryDestViewModel outModel = service.customerChange(inModel);
		
		return outModel;
	}
}
