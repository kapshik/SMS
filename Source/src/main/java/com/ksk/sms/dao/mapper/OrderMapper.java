package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.Order;

@Mapper
public interface OrderMapper {

	public Order findOne(Order customer);

	public List<Order> findList(Order customer);
	
	public long count(Order customer);
	
	public int create(Order customer);
	
	public int createAll(List<Order> customers);

	public int update(Order customer);

	public int delete(Order customer);

}
