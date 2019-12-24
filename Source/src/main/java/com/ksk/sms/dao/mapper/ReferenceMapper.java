package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.Reference;

@Mapper
public interface ReferenceMapper {

	public List<Reference> findList(@Param("type")String type);

}
