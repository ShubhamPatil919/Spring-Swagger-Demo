package com.springboot.swagger.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.springboot.swagger.*.*.*(..))") // com.springboot.swagger.restapi.EmployeeApi.getAllEmployee(..)
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = joinPoint.getSignature().getName();// GetMethod name which is invoked
		String className = joinPoint.getTarget().getClass().toString();// Get Class Name
		Object[] array = joinPoint.getArgs();

		log.info("Method Invoked---> " + className + ":" + methodName + "()" + " Arguments--> "
				+ mapper.writeValueAsString(array));

		log.error("An Error has Occured"+className);

		Object object = joinPoint.proceed();

		log.info("Response Method ---> " + className + ":" + methodName + "()" + " Response--> "
				+ mapper.writeValueAsString(object));

		return object;

	}
}
