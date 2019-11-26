package com.ksk.sms.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ksk.sms.model.OrderViewModel;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@SessionAttributes("orderViewModel") 
public class OrderRestController {

	@Autowired
	private SmsViewService<OrderViewModel> service;
	
	@GetMapping("order/init")
	public OrderViewModel init() {
		OrderViewModel outModel = service.init();
		
    	log.info("--------------------------------------");
		setSessionAttribute(outModel);
		return outModel;
	}
	
	@PostMapping("order/search")
	public OrderViewModel search(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		setSessionAttribute(outModel);
		return outModel;
	}
	
	@PostMapping("order/delete")
	public OrderViewModel delete(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/customerChange")
	public OrderViewModel customerChange(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
    @ModelAttribute("orderViewModel")
    public OrderViewModel setSessionAttribute(OrderViewModel inModel){
    	log.info("orderViewModel = {}", inModel);

        return inModel;
    }

}
