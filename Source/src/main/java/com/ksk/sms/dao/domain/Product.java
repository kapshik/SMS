package com.ksk.sms.dao.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
    private String productCode;
    private String productName;
    private int quantity;
    private int quantityPerBox;
    private int quantityOfBox;
    private int buyPrice;
    private int unitPrice;
    private String productType;
    private String unitType;
    private String remarks;
    private Date scheduledInStockDate;
    private int quantityInStock;
}
