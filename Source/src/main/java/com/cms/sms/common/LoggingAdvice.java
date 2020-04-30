package com.cms.sms.common;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private Logger logger;
    
    public LoggingAdvice() {
//        this.logger = LogManager.getLogger(getClass());
    }
	
    @Before("execution(* com.cms.sms..*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
//        logger.info("Before " + joinPoint.getTarget().getClass().toString());
    }

    @Around("execution(* com.cms.sms..*.*(..))")
    public Object  aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    	this.logger = LogManager.getLogger(joinPoint.getTarget().getClass());
//    	outputLog(joinPoint);
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
//        outputLog(joinPoint);
    }

    @After("execution(* com.cms.sms..*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
//        logger.info("After " + joinPoint.getTarget().getClass().toString());
    }

    private void outputLog(ProceedingJoinPoint joinPoint) {
		String logMessage = "[ " +  getClassName(joinPoint) + "." + getSignatureName(joinPoint) + ":START:" + getArguments(joinPoint) + " ]";
		logger.info(logMessage);
	}

	private String getClassName(ProceedingJoinPoint joinPoint) {
		return joinPoint.getTarget().getClass().toString();
	}

	private String getSignatureName(ProceedingJoinPoint joinPoint) {
		return joinPoint.getSignature().getName();
	}

	private String getArguments(ProceedingJoinPoint joinPoint) {
		if (joinPoint.getArgs() == null) {
			return "argument is null";
		}

		Object[] arguments = joinPoint.getArgs();
		ArrayList<String> argumentStrings = new ArrayList<String>();

		for (Object argument : arguments) {
			if (argument != null) {
				argumentStrings.add(argument.toString());
			}
		}
		return String.join(",", argumentStrings);
	}
}
