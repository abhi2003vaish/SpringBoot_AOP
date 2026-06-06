package com.example.AOP_App.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    @Before("execution(* com.example.AOP_App.services.Impl.ShipmentServiceImpl.*(..))")
//    public void beforeShipmentServiceMethod(JoinPoint joinPoint){
//        log.info("before method call: {}", joinPoint.getSignature());
//    }


    //only run for the orderPackage method
//    @Before("execution(* orderPackage(..))")
//    only run for the orderPackage method in ShipmentServiceImpl class
//    @Before("execution(* com.example.AOP_App.services.Impl.ShipmentServiceImpl.orderPackage(..))")
    @Before("execution(* com.example.AOP_App.services.Impl.*.orderPackage(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before orderPackage called from LoggingAspect");

    }

//  run for all methods in Impl
    @Before("execution(* com.example.AOP_App.services.Impl.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect kind: {}",joinPoint.getKind());
        log.info("Before called from LoggingAspect Signature: {}",joinPoint.getSignature());

    }

    @Before("within(com.example.AOP_App.services.Impl.*)")
    public void beforeServiceImplCalls() {
        log.info("service impl calls");
    }

    @Before("within(com.example.AOP_App..*)")
    public void beforeAllCalls() {
        log.info("run for all calls");
    }

//  only run for the @Transactional annotation method
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotationCalls(){
        log.info("before Transactional annotation calls");
    }


//    only run for the @MyLogging annotation method
    @Before("@annotation(com.example.AOP_App.aspect.MyLogging)")
    public void beforeMyLoggingAnnotationCalls(){
        log.info("before MyLogging annotation calls");
    }

    @Pointcut("@annotation(com.example.AOP_App.aspect.MyLogging) && within(com.example.AOP_App.services.Impl.*)")
    public void myLoggingAndInsideImplMethodsPointCut(){}

    @Before("myLoggingAndInsideImplMethodsPointCut()")
    public void beforeMyLoggingAndInsideImplCalls(){
        log.info("calls only when @MyLogging inside the Impl methods");
    }


}
