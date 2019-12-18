package com.ksk.sms.service.common;

import org.springframework.stereotype.Service;

import com.ksk.sms.model.AddressModel;

@Service
public interface SmsAddressService {

    public AddressModel getAddressModel(String zipcode);
    public String getAddress(String zipcode);

}
