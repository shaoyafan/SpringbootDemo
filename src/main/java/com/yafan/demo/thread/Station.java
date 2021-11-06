package com.yafan.demo.thread;

/**
* @Description:
* @Param:
* @return:
* @Author: shaoyafan
* @Date: 2021/11/3
*/

public class Station extends Thread{

    // 通过构造方法给线程赋值
    Station(String name){
        super(name);
    }

    // 设置静态票数
    public static int tickets = 20;
    //设置钥匙
    static Object ob = "aa";


    @Override
    public void run() {
       while (tickets > 0){
           synchronized (ob){
               if (tickets > 0){
                   System.out.println(getName()+ "卖出第"+tickets+"张票");
                   tickets--;
               } else {
                   System.out.println("票卖完了");
               }
           }
           try {
               //休息1s
               sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
