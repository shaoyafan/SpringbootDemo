package com.yafan.demo.datasource;



import com.yafan.demo.meiju.DynamicDataSourceEnum;

import java.lang.annotation.*;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/20:53
 * @Description: 数据源的切换
 */
@Retention(RetentionPolicy.RUNTIME) //Retention:保留；–什么时候使用该注解，即注解的生命周期，使用RetentionPolicy来指定
@Target(ElementType.METHOD)  //注解用于什么地方，默认值为任何元素，表示该注解用于什么地方
@Documented // 注解是否将包含在JavaDoc中
public @interface DataSourceSelector {
    DynamicDataSourceEnum value() default DynamicDataSourceEnum.MASTER;
    boolean clear() default true;
}
