package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.OrderDetail;

@Mapper
public interface OrderDetailMapper {

	public OrderDetail findOne(OrderDetail customer);

	public List<OrderDetail> findList(OrderDetail customer);
	
	public long count(OrderDetail customer);
	
	public int create(OrderDetail customer);
	
	public int createAll(List<OrderDetail> customers);

	public int update(OrderDetail customer);

	public int delete(OrderDetail customer);

}
