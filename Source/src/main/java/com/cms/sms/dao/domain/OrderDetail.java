package com.cms.sms.dao.domain;

import lombok.Data;

@Data
public class OrderDetail {
    private String customerNo;
    private String orderNo;
    private String productCode;
    private int quantityOrdered;
    private int priceOrdered;
}
