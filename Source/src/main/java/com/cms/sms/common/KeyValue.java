package com.cms.sms.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyValue implements Serializable{

	private static final long serialVersionUID = 1L;
    private String key;
    private String value;
}