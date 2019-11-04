package com.ksk.sms.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksk.sms.model.dao.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

	@Query(value="SELECT * FROM T_USER WHERE USER = :usr", nativeQuery = true)
	public UserInfo getUserInfo(@Param("usr")String user);

}
