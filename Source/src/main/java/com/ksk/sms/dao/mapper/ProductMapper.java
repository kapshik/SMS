package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.Product;

@Mapper
public interface ProductMapper {

	public Product findOne(Product customer);

	public List<Product> findList(Product customer);
	
	public long count(Product customer);
	
	public int create(Product customer);
	
	public int createAll(List<Product> customers);

	public int update(Product customer);

	public int delete(Product customer);

}
