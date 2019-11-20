package com.ksk.sms.service.view;

import com.ksk.sms.model.BranchViewModel;

public interface BranchService {

    public BranchViewModel init();

    public BranchViewModel search(BranchViewModel inModel);

    public BranchViewModel create(BranchViewModel inModel);

    public BranchViewModel update(BranchViewModel inModel);

    public BranchViewModel delete(BranchViewModel inModel);

    public BranchViewModel customerChange(BranchViewModel inModel);

    public BranchViewModel branchChange(BranchViewModel inModel);

    public BranchViewModel close(BranchViewModel inModel);
}
