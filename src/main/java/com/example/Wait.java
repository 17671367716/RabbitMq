package com.example;

/**
 * join
 */

public class Wait {

    public static void main(String[] args) {
        System.out.println("main start");
        long start = System.currentTimeMillis();
        Thread thread_1 = new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " => " +i);
            }
        },"Thread_1");
        thread_1.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("runtime: " + (end - start) );
    }

}
