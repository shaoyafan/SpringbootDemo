package com.yafan.demo.aop;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/19:27
 * @Description:
 */
public class testAopImpl implements testAop{

    @Override
    public void printHello() {
        System.out.println("测试测试测试测试测试测试测试测试");
    }

    @Override
    public boolean doPrint() {
        System.out.println("############测试testAopImpl类");
        return true;
    }
}
