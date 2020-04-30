package com.cms.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cms.sms.dao.domain.Customer;

@Mapper
public interface ValidationMapper {

	public long count(@Param("tablename") String tableName, @Param("columnname") String columnName, @Param("value") String value);

}
