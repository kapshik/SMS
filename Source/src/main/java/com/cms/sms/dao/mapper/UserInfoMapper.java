package com.cms.sms.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cms.sms.dao.domain.UserInfo;

@Mapper
public interface UserInfoMapper {

	public UserInfo getUserInfo(@Param("user")String user);

}
