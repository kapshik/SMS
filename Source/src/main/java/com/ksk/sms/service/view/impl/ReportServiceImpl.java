package com.ksk.sms.service.view.impl;

import org.springframework.stereotype.Service;

import com.ksk.sms.model.ReportViewModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReportServiceImpl extends SmsService implements SmsViewService<ReportViewModel> {

	@Override
    public ReportViewModel init() {

        ReportViewModel outModel = new ReportViewModel();

log.info("init");
    	return outModel;
    }

	@Override
	public ReportViewModel search(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel create(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel update(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel delete(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel customerChange(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel branchChange(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReportViewModel close(ReportViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
