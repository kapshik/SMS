package com.ksk.sms.service.report.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.presentation.controller.CommonController;
import com.ksk.sms.service.report.DeliveryReportService;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@Log4j2
@Service
public class DeliveryReportServiceImpl implements DeliveryReportService  {
	
	@Autowired
	DeliveryReportFactory reportFactory;

	public void mekeReport(HttpServletResponse response, String option) throws IOException, JRException {
//		String outFileName = "Delivery_" + LocalDate.now() + ".pdf";
		String outFileName = "納品書_" + LocalDate.now() + ".pdf";

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", option + "; filename=" + URLEncoder.encode(outFileName, "UTF-8"));
		response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");

		Collection<Map<String, ?>> source = reportFactory.makeList();
		Map<String, Object> parameters = reportFactory.makeParameters();

		InputStream inputStream = CommonController.class.getResourceAsStream("/report/Delivery.jrxml");
		OutputStream outputStream = response.getOutputStream();

		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRMapCollectionDataSource(source));
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		log.info(outFileName);
	}
	
}
