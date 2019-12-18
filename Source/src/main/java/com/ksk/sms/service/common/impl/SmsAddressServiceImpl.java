package com.ksk.sms.service.common.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ksk.sms.dao.domain.Address;
import com.ksk.sms.dao.mapper.AddressMapper;
import com.ksk.sms.model.AddressModel;
import com.ksk.sms.service.common.SmsAddressService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SmsAddressServiceImpl implements SmsAddressService {

    @Autowired
    private AddressMapper addressMapper;
	
	@Override
	public AddressModel getAddressModel(String zipcode) {
		
		Address address = addressMapper.findOne(zipcode);

		AddressModel addressModel = new AddressModel(); 
		addressModel.setAddress1(address.getKenName());
		addressModel.setAddress2(address.getCityName());
		addressModel.setAddress3(address.getTownName());

		return addressModel;
	}

	@Override
	public String getAddress(String zipcode) {
		
	    RestTemplate restTemplate = new RestTemplate();
	    
    	final String uri = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zipcode.replace("-", "");
		log.info(uri);	    
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		log.info(result);	    
		return result.getBody();
	}

}
