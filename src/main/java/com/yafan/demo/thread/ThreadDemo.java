package com.yafan.demo.thread;

public class ThreadDemo {

    public static void main(String[] args) {
//        for (int i = 0; i < 30; i++) {
//            System.out.println("main"+i);
//
//            if(i==10){
//                MyThread myThread = new MyThread("线程");
//                myThread.start();
//            }
//
//        }

        //继承Thread类
//        Station station1 = new Station("窗口1");
//        Station station2 = new Station("窗口2");
//        Station station3 = new Station("窗口3");
//        Station station4 = new Station("窗口4");
//        station1.start();
//        station2.start();
//        station3.start();
//        station4.start();

        //实现Runnable
        Station2 t1 = new Station2("窗口1");
        Station2 t2 = new Station2("窗口2");
        Station2 t3 = new Station2("窗口3");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}
