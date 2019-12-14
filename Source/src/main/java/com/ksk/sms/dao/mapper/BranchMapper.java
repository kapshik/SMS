package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ksk.sms.dao.domain.Branch;

@Mapper
public interface BranchMapper {

	public Branch findOne(Branch data);

	public List<Branch> findList(Branch data);
	
	public long count(Branch data);
	
	public int create(Branch data);
	
	public int createAll(@Param("list") List<Branch> data);

	public int update(Branch data);

	public int delete(Branch data);

}
