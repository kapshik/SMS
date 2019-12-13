package com.ksk.sms.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.Address;

@Mapper
public interface AddressMapper {

	public Address findOne(@Param("zipcode")String zipcode);

}
