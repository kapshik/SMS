package com.ksk.sms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.ksk.sms.common.KeyValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String customerNo;
	private String customerName;
    private String productCode;
    private String productName;
    private int quantity;
    private int quantityPerBox;
    private int quantityOfBox;
    private int buyPrice;
    private int unitPrice;
    private String productType;
    private String unitType;
	private String productTypeName;
	private String unitTypeName;
    private String remarks;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate scheduledInStockDate;
    private int quantityInStock;

    private int discountPrice;
    private int amount;

	private List<KeyValue> productTypeList;
	private List<KeyValue> unitTypeList;
	private List<KeyValue> productMasterList;
}

