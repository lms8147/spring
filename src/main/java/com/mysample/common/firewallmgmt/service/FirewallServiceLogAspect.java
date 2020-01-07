package com.mysample.common.firewallmgmt.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class FirewallServiceLogAspect {

  @Pointcut("execution(* com.mysample.common.firewallmgmt.service..Impl.*(..))")
  public void allPointCut() {}

  @Pointcut("execution(* com.mysample.common.firewallmgmt.service..Impl.get*(..))")
  public void getPointCut() {}

  @Before("allPointCut()")
  public void logBeforeMethodCall(JoinPoint jp) {
    Logger log = LoggerFactory.getLogger(jp.getKind());
    log.info(jp.getSignature().getName() + "메소드 호출");
    log.info("매개변수");
    for (Object arg : jp.getArgs()) {
      log.info(arg.toString());
    }
  }

  @AfterReturning(pointcut = "getPointCut()", returning = "returnObj")
  public void logAfterMethodCall(JoinPoint jp, Object returnObj) {
    Logger log = LoggerFactory.getLogger(jp.getKind());
    log.info(jp.getSignature().getName() + "메소드 리턴");
    log.info("리턴 값" + returnObj.toString());
  }
}
