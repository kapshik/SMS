package com.cms.sms.dao.domain;

import lombok.Data;

@Data
public class DeliveryDest {
    private String deliveryDestNo;
    private String branchNo;
    private String customerNo;
    private String deliveryDestName;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String telNo;
    private String faxNo;
}
