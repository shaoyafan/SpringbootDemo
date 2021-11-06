package com.yafan.demo.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/03/22:19
 * @Description:
 */
public class ThreadPool implements Runnable{


    int tickets = 30;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "ThreadPool");
    }

    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(3);

        // 设置线程池属性
        ThreadPoolExecutor s = (ThreadPoolExecutor) service;
//         s.setCorePoolSize();

        // 执行指定线程操作
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool());
        service.execute(new ThreadPool1());
        // 关闭
        service.shutdown();
    }



}

class ThreadPool1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "ThreadPool1");
    }
}

