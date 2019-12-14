package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.OrderDetail;

@Mapper
public interface OrderDetailMapper {

	public OrderDetail findOne(OrderDetail data);

	public List<OrderDetail> findList(OrderDetail data);
	
	public long count(OrderDetail data);
	
	public int create(OrderDetail data);
	
	public int createAll(@Param("list") List<OrderDetail> data);

	public int update(OrderDetail data);

	public int delete(OrderDetail data);

}
