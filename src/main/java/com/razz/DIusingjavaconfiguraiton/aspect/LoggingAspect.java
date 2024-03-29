package com.razz.DIusingjavaconfiguraiton.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);
//    @Before(value="execution( * com.razz.DIusingjavaconfiguraiton.service.BookServiceImpl.*(..))")
//    public void logBeforeMethodStart(JoinPoint joinPoint){
//
//
//        log.info("******STARTED {}",joinPoint.getSignature().toShortString());
//        //log.info("****** {}",joinPoint.getArgs());
//    }
//

    @Around("execution(* com.razz.DIusingjavaconfiguraiton.service.BookServiceImpl.deleteBook(..)))")
    public Object  delete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("******EXECUTION STARTED {}",proceedingJoinPoint.getSignature().getName());
        Object proceed = proceedingJoinPoint.proceed();
        log.info("******EXECUTION FINISHED {}",proceedingJoinPoint.getSignature().getName());
        return proceed;
    }
    @AfterThrowing(pointcut="execution(* com.razz.DIusingjavaconfiguraiton.service.BookServiceImpl.deleteBook(..)))",throwing="ex")
    public void  deleteException(JoinPoint joinPoint, Exception ex) throws Throwable {
        log.error("Exception in {},{}",joinPoint.getSignature().getName(), ex.getMessage());
    }
}
