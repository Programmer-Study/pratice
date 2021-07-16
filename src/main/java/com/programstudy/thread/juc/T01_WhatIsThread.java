package com.programstudy.thread.juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : T01_WhatIsThread  //类名
 * @Description : 多线程最初版设计  //描述
 * @Author : geyongfei  //作者
 * @Date: 2021-07-14 00:54  //时间
 * @Version: 1.0
 */
public class T01_WhatIsThread {
    private static class T1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //new T1().run();           //按代码的顺序先执行T1，T1执行完后，再继续运行后续代码
        new T1().start();           //在正常执行代码块时，如果遇到start则，会启动另外一个线程执行start同时，当前主线程继续运行
        for (int i = 0; i < 10; i++) {
            try{
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
