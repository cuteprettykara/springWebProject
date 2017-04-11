package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class SampleAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* org.zerock.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("------------------------------");
		logger.info("------------------------------");
		logger.info(Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* org.zerock.service.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info(Arrays.toString(pjp.getArgs()));
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object object = pjp.proceed();
		stopWatch.stop();
		
		logger.info(pjp.getSignature().getName() + " : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		logger.info("======================================================");
		
		return object;
		
	}
}
