package com.dylan.multithread;

/**
 * @description: 找一下线程等待的感觉
 * @author: Mr.Mu
 * @create: 2018-02-27 18:29
 **/
public class TestWait {

    public static void main(String[] args) {
        try {
            Test test=  new Test();
            Thread.sleep(2000);
            test.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   static class  Test extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(500);
                    System.out.println("线程测试");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
