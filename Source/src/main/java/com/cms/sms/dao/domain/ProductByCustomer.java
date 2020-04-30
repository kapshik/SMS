package com.cms.sms.dao.domain;

import lombok.Data;

@Data
public class ProductByCustomer {
    private String customerNo;
    private String productCode;
    private int discountPrice;
}
