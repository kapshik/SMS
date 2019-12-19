package com.ksk.sms.service.common.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksk.sms.dao.domain.Address;
import com.ksk.sms.dao.mapper.AddressMapper;
import com.ksk.sms.model.AddressModel;
import com.ksk.sms.model.ZipCloudModel;
import com.ksk.sms.service.common.SmsAddressService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SmsAddressServiceImpl implements SmsAddressService {

	static final String ZIPCLOUD_URI = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=";
	
    @Autowired
    private AddressMapper addressMapper;

	@Autowired
	private ObjectMapper objectMapper;
	
	private RestTemplate restTemplate;
	 
	@Autowired
	public SmsAddressServiceImpl(RestTemplateBuilder builder) {
	    this.restTemplate = builder.build();
	}
	
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
	public AddressModel getAddressModelByObject(String zipcode) {
		
    	final String uri = ZIPCLOUD_URI + zipcode.replace("-", "");
		log.info(uri);	    
/*
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		ResponseEntity<ZipCloudModel> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ZipCloudModel.class);
*/		
		String result = restTemplate.getForObject(uri, String.class);
		ZipCloudModel zipCloudModel = null;
		try {
			zipCloudModel = objectMapper.readValue(result, ZipCloudModel.class);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		AddressModel addressModel = zipCloudModel.getResults().get(0); 
		log.info(addressModel.getAddress1()+addressModel.getAddress2()+addressModel.getAddress3());

		return addressModel;
		
	}

	@Override
	public String getAddress(String zipcode) {
		
    	final String uri = ZIPCLOUD_URI + zipcode.replace("-", "");
		log.info(uri);	    
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		log.info(result);	    
		return result.getBody();
		
	}

}
