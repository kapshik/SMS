package com.ksk.sms.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice(annotations = RestController.class)
public class SmsRestControllerAdvice {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
//		log.debug("initBinder : {}", dataBinder);
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ModelAttribute
	public void handleRequest(HttpServletRequest request, Model model) {
//		model.addAttribute("username", SmsUserInfoUtil.getUsername());
//      model.addAttribute("isAdmin", SmsUserInfoUtil.getRole().equals("ROLE_ADMIN") );

//        log.info(model);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleSystemException(Exception e) {
		log.error("System Error occurred.", e);
		return "sms-home";
	}

}
