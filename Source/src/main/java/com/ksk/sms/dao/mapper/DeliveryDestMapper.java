package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.DeliveryDest;

@Mapper
public interface DeliveryDestMapper {

	public DeliveryDest findOne(DeliveryDest customer);

	public List<DeliveryDest> findList(DeliveryDest customer);
	
	public long count(DeliveryDest customer);
	
	public int create(DeliveryDest customer);
	
	public int createAll(List<DeliveryDest> customers);

	public int update(DeliveryDest customer);

	public int delete(DeliveryDest customer);

}
