package com.ksk.sms.service.common;

import com.ksk.sms.common.SmsUserInfoUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsService {

	protected String getUsername() {
		log.debug("getUsername");
		return SmsUserInfoUtil.getUsername();
	}

	protected String getRole() {
		return SmsUserInfoUtil.getRole();
	}
}
