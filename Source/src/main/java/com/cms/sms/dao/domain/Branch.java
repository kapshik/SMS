package com.cms.sms.dao.domain;

import lombok.Data;

@Data
public class Branch {
    private String branchNo;
    private String customerNo;
    private String branchName;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String telNo;
    private String faxNo;
}
