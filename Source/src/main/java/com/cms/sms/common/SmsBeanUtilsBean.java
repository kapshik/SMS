package com.cms.sms.common;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.Converter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsBeanUtilsBean {

	public static void copyProperties(Object dest, Object orig) {
        try {
        	BeanUtils.copyProperties(dest, orig);
//        	BeanUtilsBean bu = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
//        	bu.getConvertUtils().register(new SmsDateConverter(), LocalDate.class);
//	    	bu.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private final static class SmsDateConverter implements Converter {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
		
        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public Object convert(Class targetClass, Object value) {
        	if (value instanceof LocalDate) {
        		return value;
        	}
			try {
				return formatter.parse(value.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			log.info("Return NULL!");
			return null;
        }
    }	
}
