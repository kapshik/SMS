package com.ksk.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ksk.sms.dao.mapper.ValidationMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private ValidationMapper validationMapper;

    private String tableName;
    private String columnName;

	@Override
	public void initialize(UniqueName annotation) {
		tableName = annotation.tableName();
		columnName = annotation.columnName();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext ctx) {
		long count = validationMapper.count(tableName, columnName, value);
		log.info(count);
		return count == 0;
	}
}
