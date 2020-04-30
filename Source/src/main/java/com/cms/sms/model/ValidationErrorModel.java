package com.cms.sms.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String message;
}
