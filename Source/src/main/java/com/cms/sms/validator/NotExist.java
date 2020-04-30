package com.cms.sms.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotExistValidator.class})
public @interface NotExist {

	String message() default "同じのデータが既に存在します。";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String tableName();
	String columnName();
	
	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		NotExist[] value();
	}

}
