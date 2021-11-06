package com.yafan.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/19:35
 * @Description:
 */

@Aspect
@Component
public class TestAspect {

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.yafan.demo.controller..*.*(..))")
    public void phe(){}

    @Before("phe()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        Object target = joinPoint.getTarget();

        System.out.println("切入成功*****************");
    }

    @AfterReturning(returning = "ret",pointcut = "phe()")
    public void retrn(Object ret){
        // 处理完请求，返回内容
        System.out.println("处理完成*********+"+ ret);
    }
}
