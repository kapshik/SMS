package com.cms.sms.service.common;

import org.springframework.stereotype.Service;

import com.cms.sms.model.AddressModel;

@Service
public interface SmsAddressService {

    public AddressModel getAddressModel(String zipcode);
    public String getAddress(String zipcode);
	public AddressModel getAddressModelByObject(String zipcode);
}
