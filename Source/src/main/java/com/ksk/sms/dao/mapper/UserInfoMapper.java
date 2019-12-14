package com.ksk.sms.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.UserInfo;

@Mapper
public interface UserInfoMapper {

	public UserInfo getUserInfo(@Param("user")String user);

}
