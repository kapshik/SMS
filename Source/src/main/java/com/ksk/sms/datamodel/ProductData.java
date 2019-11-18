package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import com.ksk.sms.common.KeyValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductData implements Serializable{

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
	private String remarks;

	private List<KeyValue> productTypeList;
	private List<KeyValue> unitTypeList;
	private List<KeyValue> productMasterList;
}

