package com.ksk.sms.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String productData;
	private String shippingQuantity;
	private String storedQuantity;
	private String stockTakeQuantity;
	private String quantityOfStock;
	private String quantityPerBox;
	private String quantityOfBox;
	private String balanceOfStock;
	private String unitPrice;
	private String shippingDate;
	private String storedDate;
	private String stocktakeDate;
}

