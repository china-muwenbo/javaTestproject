package com.dylan.multithread.blockingqueue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @description: 测试阻塞队列 和 golang chan 好像
 * @author: Mr.Mu
 * @create: 2018-02-26 14:24
 **/
/*
BlockingQueue的核心方法：
放入数据：
　　offer(anObject):表示如果可能的话,将anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,
　　　　则返回true,否则返回false.（本方法不阻塞当前执行方法的线程）
　　offer(E o, long timeout, TimeUnit unit),可以设定等待的时间，如果在指定的时间内，还不能往队列中
　　　　加入BlockingQueue，则返回失败。
　　put(anObject):把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断
　　　　直到BlockingQueue里面有空间再继续.
获取数据：
　　poll(time):取走BlockingQueue里排在首位的对象,若不能立即取出,则可以等time参数规定的时间,
　　　　取不到时返回null;
　　poll(long timeout, TimeUnit unit)：从BlockingQueue取出一个队首的对象，如果在指定时间内，
　　　　队列一旦有数据可取，则立即返回队列中的数据。否则知道时间超时还没有数据可取，返回失败。
　　take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到
　　　　BlockingQueue有新的数据被加入;
　　drainTo():一次性从BlockingQueue获取所有可用的数据对象（还可以指定获取数据的个数），
　　　　通过该方法，可以提升获取数据效率；不需要多次分批加锁或释放锁。
*
* */

/**
 * 利用生产者消费者的模型去理解阻塞队列。
 * 一个线程生产，一个线程消费
 *  如果生产了4个 消费3个 目前并不能阻塞队列
 *  //LinkedTransferQueue 生产速度慢，消费速度快，消费者会等待生产者
 *  生产0
    拿出来=0
    生产1
    拿出来=1
    生产2
    拿出来=2
    生产3
    拿出来=3
 *  生产速度快，消费速度慢，消费逐步进行。消费者会阻塞线程 没有东西消费的话
 *  生产完成
    拿出来=0
    拿出来=1
    拿出来=2
    拿出来=3
    拿出来=4
    阻塞

 *
 *
 * */




public class MyLinkedTransferQueue {
    // 同步的无缓冲区队列
    public static LinkedTransferQueue<String> stringBlockingDeque = new LinkedTransferQueue<String>();

    public static void main(String[] args) {
       new MyLinkedTransferQueue().test();
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

                stringBlockingDeque.add(""+i);
                System.out.println("生产"+i);
                try {
                    Thread.sleep(2000);
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
                    String take= MyLinkedTransferQueue.stringBlockingDeque.take();
                    System.out.println("拿出来="+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费完成");
        }
    }

}
