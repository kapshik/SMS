package com.ksk.sms.presentation.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksk.sms.service.report.impl.TestReportDataFactory;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

@Controller
public class CommonController {

//  TODO
//  エラー設計後作成
//	@RequestMapping("error")	
//	public String errorForm(Model model) {
//		return "base/error";
//	}

	// ログイン画面
    @RequestMapping({"/", "/login.html", "/invalidSession"})	
    public String loginForm(Model model) {
        return "login";
    }

//	エントリ画面（login後）
	@RequestMapping("/sms-home.html")	
	public String homeForm(Model model) {
		return "sms-home";
	}
}
