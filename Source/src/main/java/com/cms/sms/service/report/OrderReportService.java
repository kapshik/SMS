package com.cms.sms.service.report;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

public interface OrderReportService {
	
	public void mekeReport(HttpServletResponse response, String option) throws IOException, JRException;
	
}
