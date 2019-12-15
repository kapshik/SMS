package com.ksk.sms.presentation.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ksk.sms.service.report.DeliveryReportService;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;

@Log4j2
@RestController
public class DeliveryRestController {

	@Autowired
	private DeliveryReportService reportService;
	
	@PostMapping("delivery/download")
	public void download(ModelAndView model, HttpServletResponse response) throws IOException, JRException {

		reportService.mekeReport(response, "attachment");
		log.info("attachment");
	}

	@PostMapping("delivery/display")
	public void display(ModelAndView model, HttpServletResponse response) throws IOException, JRException {
		
		reportService.mekeReport(response, "inline");
		log.info("inline");
	}
}
