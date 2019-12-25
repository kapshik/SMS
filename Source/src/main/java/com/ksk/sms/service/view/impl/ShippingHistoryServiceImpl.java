package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ksk.sms.model.ShippingHistoryModel;
import com.ksk.sms.model.ShippingHistoryViewModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ShippingHistoryServiceImpl extends SmsService implements SmsViewService<ShippingHistoryViewModel> {
	
	@Override
    public ShippingHistoryViewModel init() {

		ShippingHistoryViewModel outModel = new ShippingHistoryViewModel();

		outModel.setShippingHistoryModelList(makeShippingHistoryModelList());
    	
    	log.info("SmsShippingHistoryServiceImpl init");
    	return outModel;
    }

	@Override
	public ShippingHistoryViewModel search(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel create(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel update(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel delete(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel customerChange(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel branchChange(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel close(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShippingHistoryViewModel deliveryDestChange(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	protected List<ShippingHistoryModel> makeShippingHistoryModelList() {
        List<ShippingHistoryModel> shippingHistoryModelList = new ArrayList<ShippingHistoryModel>();

		Random random = new Random();
		for(int i=1; i<50; i++) {
	        ShippingHistoryModel shippingHistoryModel = new ShippingHistoryModel();

			shippingHistoryModel.setProductCode("CODE_" + random.nextInt(10)+i);
			shippingHistoryModel.setProductName("商品名　"+ random.nextInt(1000));
			shippingHistoryModel.setNum01(random.nextInt(1000));
			shippingHistoryModel.setNum02(random.nextInt(1000));
			shippingHistoryModel.setNum03(random.nextInt(1000));
			shippingHistoryModel.setNum04(random.nextInt(1000));
			shippingHistoryModel.setNum05(random.nextInt(1000));
			shippingHistoryModel.setNum06(random.nextInt(1000));
			shippingHistoryModel.setNum07(random.nextInt(1000));
			shippingHistoryModel.setNum08(random.nextInt(1000));
			shippingHistoryModel.setNum09(random.nextInt(1000));
			shippingHistoryModel.setNum10(random.nextInt(1000));
			shippingHistoryModel.setNum11(random.nextInt(1000));
			shippingHistoryModel.setNum12(random.nextInt(1000));
			shippingHistoryModel.setNum13(random.nextInt(1000));
			shippingHistoryModel.setNum14(random.nextInt(1000));
			shippingHistoryModel.setNum15(random.nextInt(1000));
			shippingHistoryModel.setNum16(random.nextInt(1000));
			shippingHistoryModel.setNum17(random.nextInt(1000));
			shippingHistoryModel.setNum18(random.nextInt(1000));
			shippingHistoryModel.setNum19(random.nextInt(1000));
			shippingHistoryModel.setNum20(random.nextInt(1000));
			shippingHistoryModel.setNum21(random.nextInt(1000));
			shippingHistoryModel.setNum22(random.nextInt(1000));
			shippingHistoryModel.setNum23(random.nextInt(1000));
			shippingHistoryModel.setNum24(random.nextInt(1000));
			shippingHistoryModel.setNum25(random.nextInt(1000));
			shippingHistoryModel.setNum26(random.nextInt(1000));
			shippingHistoryModel.setNum27(random.nextInt(1000));
			shippingHistoryModel.setNum28(random.nextInt(1000));
			shippingHistoryModel.setNum29(random.nextInt(1000));
			shippingHistoryModel.setNum30(random.nextInt(1000));
			shippingHistoryModel.setNum31(random.nextInt(1000));
			shippingHistoryModel.setSum(random.nextInt(10000));

			shippingHistoryModelList.add(shippingHistoryModel);
		}
        return shippingHistoryModelList;
    }

	@Override
	public ShippingHistoryViewModel detail(ShippingHistoryViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
