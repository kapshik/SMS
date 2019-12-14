package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.Order;

@Mapper
public interface OrderMapper {

	public Order findOne(Order data);

	public List<Order> findList(Order data);
	
	public long count(Order data);
	
	public int create(Order data);
	
	public int createAll(@Param("list") List<Order> data);

	public int update(Order data);

	public int delete(Order data);

}
