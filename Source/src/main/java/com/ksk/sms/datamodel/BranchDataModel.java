package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;

	private BranchDataCriteria branchDataCriteria;
	private List<BranchData> branchDataList;

}

