package com.cms.sms.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cms.sms.model.SmsViewModel;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice(annotations = Controller.class)
public class SmsControllerAdvice {

	@Autowired
	private SmsViewService<SmsViewModel> service;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		log.info("initBinder : {}", dataBinder);
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ModelAttribute
	public void handleRequest(HttpServletRequest request, Model model) {
		model.addAttribute("username", SmsUserInfoUtil.getUsername());
        model.addAttribute("isAdmin", SmsUserInfoUtil.getRole().equals("ROLE_ADMIN") );
        model.addAttribute("smsViewModel", service.init());
        model.addAttribute("isListNeedBtn", false);
        
//        log.info(model);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleSystemException(Exception e) {
		log.error("System Error occurred.", e);
		return "error";
	}

}
