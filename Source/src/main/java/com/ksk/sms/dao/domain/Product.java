package com.ksk.sms.dao.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product {
    private String productCode;
    private String productName;
    private int unitPrice;
    private String productType;
	private String productTypeName;
    private String unitType;
	private String unitTypeName;
    private String remarks;
}
