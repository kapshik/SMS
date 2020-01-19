package com.ksk.sms.common;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.MessageSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@Component
public class SmsCustomFilter implements Filter {

//	private static final Logger log = LogManager.getLogger(SmsCustomFilter.class);

	private String systemName;

	public SmsCustomFilter(MessageSource messageSource) { // MessageSourceをインジェクション
		this.systemName = messageSource.getMessage("system.name", null, "demo", Locale.getDefault());
	}

	protected void initFilterBean() throws ServletException {
//		log.debug("{} : initFilterBean", systemName);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

	//    HttpServletRequest httpRequest = (HttpServletRequest)request;
	//    log.info("doFilter : {} -> {} -> {}", httpRequest.getRequestURI(), 	httpRequest.getQueryString(), httpRequest.getPathInfo());

		filterChain.doFilter(request, response);

	//    HttpServletResponse httpResponse = (HttpServletResponse)response;
	//    log.info("doFilter : {}", httpResponse.getContentType());
	}

	@Override
	public void destroy() {
//		log.debug("{} : destroy", systemName);
	}

}
