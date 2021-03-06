package com.ksk.sms.service.report.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class InvoiceReportFactory {

	public Collection<Map<String, ?>> makeList() {
		Collection<Map<String, ?>> list = new ArrayList<>();
		Random random = new Random();
		for(int i=1; i<100; i++) {
			Map<String, Object> rowData = new HashMap<>();

			rowData.put("no", String.format("%04d", i));
			rowData.put("productName", "品名"+String.format("%04d", random.nextInt(1000)));
			rowData.put("quantity", random.nextInt(100));
			rowData.put("box", random.nextInt(10));
			rowData.put("unitPrice", random.nextInt(999));
			rowData.put("amount", random.nextInt(10000));
			rowData.put("branch", "営業所"+String.format("%04d", random.nextInt(9999)));
			rowData.put("orderNo", "A"+String.format("%04d", random.nextInt(9999))+String.format("-%06d",random.nextInt(999999))+String.format("-%d",random.nextInt(9)));
			
			list.add(rowData);
		}

		return list;
	}

	public Map<String, Object> makeParameters() {
		Map<String, Object> parameters = new HashMap<>();

		parameters.put("ReportTitle", "請　求　書");
		
		parameters.put("customerAddress1", "東京都港区港南2-16-2");
		parameters.put("customerAddress2", "太陽生命品川ビル20F");
		parameters.put("customerName", "株式会社シーエムエス　御中");
		
		parameters.put("staffName", "宋　承必");
		parameters.put("zipcode", "135-0004");
		parameters.put("address1", "東京都江東区森下5-11-8");
		parameters.put("address2", "荒川ビル2F");
		parameters.put("companyName", "株式会社ティ・エム・シー");
		parameters.put("tel", "03-6659-3871");
		parameters.put("fax", "03-6659-3872");
		parameters.put("issuedDate", new Date());
		parameters.put("invoiceNo", "IV-" + LocalDate.now().getYear() + "-" + "001");
		
		parameters.put("paymentTerms", "●　月末閉め翌月末支払い");
		parameters.put("bankAccount", "三菱UFJ銀行　虎ノ門支店　普通 01565##　カ）ティエムシー");

		return parameters;
	}
}
