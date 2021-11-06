package com.yafan.demo.aop;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/19:27
 * @Description:
 */
public class testAopImpl2 implements testAop{

    @Override
    public void printHello() {
        System.out.println("世界世界世界世界");
    }

    @Override
    public boolean doPrint() {
        System.out.println("***********testAopImpl2");
        return false;
    }
}
