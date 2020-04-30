package com.cms.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cms.sms.dao.domain.Customer;

@Mapper
public interface CustomerMapper {

	public Customer findOne(Customer data);

	public List<Customer> findList(Customer data);
	
	public long count(Customer data);
	
	public String nextNo(Customer data);

	public int create(Customer data);
	
	public int createAll(@Param("list") List<Customer> data);

	public int update(Customer data);

	public int delete(Customer data);

}
