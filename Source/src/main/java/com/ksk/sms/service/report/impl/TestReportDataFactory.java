package com.ksk.sms.service.report.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestReportDataFactory {

	public Collection<Map<String, ?>> makeList() {
		Collection<Map<String, ?>> orderList = new ArrayList<>();
		
		for(int i=1; i<100; i++) {
			String strNo = Integer.toString(i);
			Map<String, Object> rowData = new HashMap<>();

			rowData.put("orderNo", strNo);
			rowData.put("customer", "顧客"+strNo);
			rowData.put("branchName", "支店"+strNo);
			rowData.put("deliveryDestination", "納品先"+strNo);
			rowData.put("orderDate", "受注日"+strNo);
			rowData.put("deliveryDate", "納品日"+strNo);
			rowData.put("shippingDate", "発送日"+strNo);
			rowData.put("creationDate", "作成日"+strNo);
			
			orderList.add(rowData);
		}

		return orderList;
	}
}
