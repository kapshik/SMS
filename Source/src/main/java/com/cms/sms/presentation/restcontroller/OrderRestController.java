package com.cms.sms.presentation.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cms.sms.model.OrderViewModel;
import com.cms.sms.service.report.OrderReportService;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;

@Log4j2
@RestController
@SessionAttributes("orderViewModel") 
public class OrderRestController {

	@Autowired
	private SmsViewService<OrderViewModel> service;
	
	@Autowired
	private OrderReportService reportService;

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
	
	@PostMapping("order/create")
	public OrderViewModel create(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.create(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/delete")
	public OrderViewModel delete(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.search(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/customerChange")
	public OrderViewModel customerChange(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.customerChange(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/branchChange")
	public OrderViewModel branchChange(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.branchChange(inModel);
		
		return outModel;
	}
	
	@PostMapping("order/deliveryDestChange")
	public OrderViewModel deliveryDestChange(@RequestBody OrderViewModel inModel) {
		OrderViewModel outModel = service.deliveryDestChange(inModel);
		
		return outModel;
	}
	
	@GetMapping("order/update/init")
	public OrderViewModel updateInit() {
		OrderViewModel initModel = service.init();
		OrderViewModel outModel = service.search(initModel);
		
		return outModel;
	}
	
	@GetMapping("order/detail/init")
	public OrderViewModel detailInit() {
		OrderViewModel initModel = service.init();
		OrderViewModel outModel = service.search(initModel);
		
		return outModel;
	}
	
    @ModelAttribute("orderViewModel")
    public OrderViewModel setSessionAttribute(OrderViewModel inModel){
    	log.info("orderViewModel = {}", inModel);

        return inModel;
    }

	@PostMapping("order/download")
	public void download(ModelAndView model, HttpServletResponse response) throws IOException, JRException {

		reportService.mekeReport(response, "attachment");
		log.info("attachment");
	}

	@PostMapping("order/display")
	public void display(ModelAndView model, HttpServletResponse response) throws IOException, JRException {
		
		reportService.mekeReport(response, "inline");
		log.info("inline");
	}

}
