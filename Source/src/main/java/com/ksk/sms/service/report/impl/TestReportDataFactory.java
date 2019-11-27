package com.ksk.sms.service.report.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestReportDataFactory {

	public Collection<Map<String, ?>> makeList() {
		Collection<Map<String, ?>> orderList = new ArrayList<>();
		Random random = new Random();
		for(int i=1; i<100; i++) {
			Map<String, Object> rowData = new HashMap<>();

			rowData.put("orderNo", String.format("%04d", i));
			rowData.put("customer", "品名"+String.format("%04d", random.nextInt(1000)));
			rowData.put("branchName", String.format("%d", random.nextInt(100)));
			rowData.put("deliveryDestination", String.format("%d", random.nextInt(10)));
			rowData.put("orderDate", String.format("%d", random.nextInt(999)));
			rowData.put("deliveryDate", String.format("%,d", random.nextInt(10000)));
			rowData.put("shippingDate", "営業所"+String.format("%04d", random.nextInt(9999)));
			rowData.put("creationDate", "A"+String.format("%04d", random.nextInt(9999))+String.format("-%06d",random.nextInt(999999))+String.format("-%d",random.nextInt(9)));
			
			orderList.add(rowData);
		}

		return orderList;
	}
}
