package com.ksk.sms.common;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SmsUserInfoUtil {

	public static String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		} else {
			return principal.toString();
		}
	}

	public static String getRole() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal instanceof UserDetails) {
			if( ((UserDetails)principal).getAuthorities().contains( new SimpleGrantedAuthority("ROLE_ADMIN") ) ) {
				return "ROLE_ADMIN";
			} else {
				return "ROLE_USER";
			}
		} else {
			return "ROLE_ADMIN";
		}
	}
}
