package com.cms.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cms.sms.dao.domain.Product;

@Mapper
public interface ProductMapper {

	public Product findOne(Product data);

	public List<Product> findList(Product data);
	
	public long count(Product data);
	
	public int create(Product data);
	
	public int createAll(@Param("list") List<Product> data);

	public int update(Product data);

	public int delete(Product data);

}
