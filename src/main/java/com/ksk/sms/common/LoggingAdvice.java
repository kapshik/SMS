package com.ksk.sms.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger logger = LogManager.getLogger(LoggingAdvice.class);
    
    @Before("execution(* com.ksk.sms..*.*(..))")
    public void adviceMethod() {
        logger.info("InfoMessage");
        logger.trace("TraceMessage");
    }
}
