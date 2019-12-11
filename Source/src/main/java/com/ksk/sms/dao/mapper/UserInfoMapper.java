package com.ksk.sms.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ksk.sms.dao.domain.UserInfo;

@Mapper
public interface UserInfoMapper {

	@Select("SELECT * FROM tbl_user WHERE USERNAME =  #{usr}")
	public UserInfo getUserInfo(@Param("usr")String user);

}
