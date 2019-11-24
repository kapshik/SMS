package com.ksk.sms.service.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsService {

	private String userName;
	
	public SmsService() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userName = ((UserDetails)principal).getUsername();
		log.info("SmsService : " + userName);
	}
	
	protected String getUserName() {
		return userName;
	}

}
