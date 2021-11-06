package com.yafan.demo.thread;

public class MyThread extends Thread{

    MyThread(String name){
        this.setName(name);
    };


    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            System.out.println(getName() +i);
        }
    }
}
