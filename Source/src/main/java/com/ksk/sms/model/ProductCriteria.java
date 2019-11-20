package com.ksk.sms.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCriteria implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String productCode;
	private String productName;
	private String quantity;
	private String quantityPerBox;
	private String quantityOfBox;
	private String unitPrice;
	private String discountPrice;
	private String amount;
	private String productType;
	private String unitType;
}

