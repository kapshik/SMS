package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.ProductByCustomer;

@Mapper
public interface ProductByCustomerMapper {

	public ProductByCustomer findOne(ProductByCustomer data);

	public List<ProductByCustomer> findList(ProductByCustomer data);
	
	public long count(ProductByCustomer data);
	
	public int create(ProductByCustomer data);
	
	public int createAll(@Param("list") List<ProductByCustomer> data);

	public int update(ProductByCustomer data);

	public int delete(ProductByCustomer data);

}
