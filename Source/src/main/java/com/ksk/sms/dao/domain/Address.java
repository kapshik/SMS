package com.ksk.sms.dao.domain;

import lombok.Data;

@Data
public class Address {
    private String id;
    private String kenId;
    private String cityId;
    private String townId;
    private String zip;
    private String officeFlg;
    private String deleteFlg;
    private String kenName;
    private String kenFuri;
    private String cityName;
    private String cityFuri;
    private String townName;
    private String townFuri;
    private String town_memo;
    private String kyoto_street;
    private String blockName;
    private String blockFuri;
    private String memo;
    private String officeName;
    private String officeFuri;
    private String officeAddress;
    private String newId;
}
