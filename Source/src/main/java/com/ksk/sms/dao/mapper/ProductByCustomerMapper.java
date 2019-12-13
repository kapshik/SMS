package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.ProductByCustomer;

@Mapper
public interface ProductByCustomerMapper {

	public ProductByCustomer findOne(ProductByCustomer customer);

	public List<ProductByCustomer> findList(ProductByCustomer customer);
	
	public long count(ProductByCustomer customer);
	
	public int create(ProductByCustomer customer);
	
	public int createAll(List<ProductByCustomer> customers);

	public int update(ProductByCustomer customer);

	public int delete(ProductByCustomer customer);

}
