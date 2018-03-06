package com.dylan.multithread.blockingqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @description: 测试 SynchronousQueue  一个阻塞队列  每一个插入操作都必须等待另一个线程的删除操作  
 * @author: Mr.Mu                         生产者速度快于消费 java.lang.IllegalStateException: Queue full
 * @create: 2018-02-27 18:08
 **/
public class MySynchronousQueue {
    //创建一个能力为3的阻塞队列
    public static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();

    public static void main(String[] args) {
        new MySynchronousQueue().test();
    }

    private  void test() {
        new Thread(new Comsumer()).start();
        new Thread(new Producter()).start();
    }

    // 一个内部类 生产者
    class Producter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronousQueue.add(""+i);
                System.out.println("生产"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产完成");
        }
    }
    // 一个内部类 生产者
    class Comsumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    String take= synchronousQueue.take();
                    System.out.println("拿出来="+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费完成");
        }
    }
}
