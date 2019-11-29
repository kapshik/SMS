package com.ksk.sms.service.report;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

public interface InvoiceReportService {
	
	public void mekeInvoice(HttpServletResponse response, String option) throws IOException, JRException;
	
}
