package com.yafan.demo.thread;

import java.util.concurrent.*;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/03/21:41
 * @Description:
 *
 * Callable又返回值
 */
public class Station3 implements Callable<String> {

    int tickets = 30;
    Object ob = "aa";

    @Override
    public String call() throws Exception {

        while (tickets > 0){
            synchronized (ob){
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName()+"卖出第"+tickets+"张票");
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
        return "ok";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable接口实现类的对象
        Station3 t1 = new Station3();
        Station3 t2 = new Station3();
        Station3 t3 = new Station3();

        // 将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask<String> futureTask = new FutureTask<>(t1);
        FutureTask<String> futureTask2 = new FutureTask<>(t2);
        FutureTask<String> futureTask3 = new FutureTask<>(t3);



    }
}
