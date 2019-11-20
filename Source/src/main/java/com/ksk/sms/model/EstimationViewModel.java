package com.ksk.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstimationViewModel extends SmsViewModel{

	private EstimationCriteria estimationCriteria;
	private List<EstimationModel> estimationModelList;

}

