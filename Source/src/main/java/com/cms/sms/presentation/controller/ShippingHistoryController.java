package com.cms.sms.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.sms.model.ShippingHistoryViewModel;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ShippingHistoryController extends SmsController {

	@Autowired
	private SmsViewService<ShippingHistoryViewModel> service;

	//	出荷履歴画面
	@RequestMapping("/sms-shipping-history.html")	
	public String mainForm(Model model) {

        model.addAttribute("shippingHistoryViewModel", service.init());
        log.info(model);
		return "sms-shipping-history";
	}

}
