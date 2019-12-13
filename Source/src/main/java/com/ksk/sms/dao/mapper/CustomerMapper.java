package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.Customer;

@Mapper
public interface CustomerMapper {

	public Customer findOne(Customer customer);

	public List<Customer> findList(Customer customer);
	
	public long count(Customer customer);
	
	public int create(Customer customer);
	
	public int createAll(List<Customer> customers);

	public int update(Customer customer);

	public int delete(Customer customer);

}
