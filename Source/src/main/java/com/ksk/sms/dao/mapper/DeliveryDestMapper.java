package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.DeliveryDest;

@Mapper
public interface DeliveryDestMapper {

	public DeliveryDest findOne(DeliveryDest data);

	public List<DeliveryDest> findList(DeliveryDest data);
	
	public long count(DeliveryDest data);
	
	public String nextNo(DeliveryDest data);

	public int create(DeliveryDest data);
	
	public int createAll(@Param("list") List<DeliveryDest> data);

	public int update(DeliveryDest data);

	public int delete(DeliveryDest data);

}
