package com.ksk.sms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ksk.sms.dao.domain.Branch;

@Mapper
public interface BranchMapper {

	public Branch findOne(Branch customer);

	public List<Branch> findList(Branch customer);
	
	public long count(Branch customer);
	
	public int create(Branch customer);
	
	public int createAll(List<Branch> customers);

	public int update(Branch customer);

	public int delete(Branch customer);

}
