package com.ksk.sms.service.view;

import com.ksk.sms.datamodel.BranchDataModel;

public interface BranchService {

    BranchDataModel init();

    BranchDataModel search(BranchDataModel inModel);

	BranchDataModel customerChange(BranchDataModel inModel);

    BranchDataModel branchChange(BranchDataModel inModel);

    BranchDataModel close(BranchDataModel inModel);
}
