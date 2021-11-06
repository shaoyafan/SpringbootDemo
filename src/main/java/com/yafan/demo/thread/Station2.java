package com.yafan.demo.thread;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/03/21:15
 * @Description:
 */
public class Station2 implements Runnable{

    private String name;

    Station2(String name){
        this.name = name;
    }

    static int tickets = 30;
    static Object ob = "bb";

    @Override
    public void run() {
        while (tickets > 0){
        synchronized (ob){
            if (tickets > 0){
                System.out.println(Thread.currentThread().getName()+ name+"卖出第"+tickets+"张票");
                tickets--;
            } else {
                System.out.println("票卖完了");
            }
        }
        try {
            //休息1s
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
