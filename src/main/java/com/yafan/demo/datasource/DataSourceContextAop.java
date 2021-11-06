package com.yafan.demo.datasource;

import com.xxl.job.core.biz.impl.ExecutorBizImpl;
import groovy.util.logging.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/06/12:59
 * @Description:
 */
@Slf4j
@Aspect
@Order(value = 1)
@Component
public class DataSourceContextAop {
    private static Logger logger = LoggerFactory.getLogger(DataSourceContextAop.class);


    @Around("@annotation(com.yafan.demo.datasource.DataSourceSelector)")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable {
        boolean clear = true;
        try {
            Method method = this.getMethod(pjp);
            DataSourceSelector dataSourceImport = method.getAnnotation(DataSourceSelector.class);
            clear = dataSourceImport.clear();
            DataSourceContextHolder.set(dataSourceImport.value().getDataSourceName());
            logger.info("========数据源切换至：{}", dataSourceImport.value().getDataSourceName());
            return pjp.proceed();
        } finally {
            if (clear) {
                DataSourceContextHolder.clear();
            }

        }
    }
    private Method getMethod(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        return signature.getMethod();
    }

}
