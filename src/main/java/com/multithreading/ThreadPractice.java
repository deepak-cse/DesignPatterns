package com.multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

class Processor extends Thread {

    private volatile boolean  running= true;
    @Override
    public void run() {
       while(running) {
           System.out.println("hello");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    public void shutdownProcessor (){
        this.running=false;
    }
}
public class ThreadPractice {

    private static volatile String val ="deepak";
    private static int count=0;
    static Object lock1 = new Object();
    public static void main(String[] args) {

//        Processor processor = new Processor();
//        processor.start();
//
//
//
//
//        System.out.println("Enter value to shutdown process");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
//        processor.shutdownProcessor();


        Thread t1 = new Thread(() -> System.out.println("inside threadt1" + Thread.currentThread()));
        t1.start();

        System.out.println("inside main method"+ Thread.currentThread());


        Thread thread = new Thread(()-> {
            for(int i=0;i<1000;i++)
            increment();
        });

        Thread thread1 = new Thread(()->{for(int i=0;i<1000;i++) increment();});

        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count"+count);

        Thread t3 = new Thread(()-> increment1());
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//        Thread t2 = new Thread(new Runnable() {
//
//            private boolean running =false;
//
//            @Override
//            public void run() {
//
//            }
//        });

//        Thread t3 = new Thread(()-> {
//             boolean val = false;
//             //int count=0;
//             while (val) {
//
//                 System.out.println("hello");
//                 Thread.sleep();
//             }
//        });
//
//        t3.start();
        //t3.




        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10);
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        //threadPoolExecutor.getThreadFactory();
    }

    private static synchronized void increment() {
            count++;

    }

    private static  void increment1() {
        synchronized (lock1) {
            count++;
        }
    }

    private void  printValue() {
        //Random r = new Random();
        //r.ints(0,10).asDoubleStream().forEach(System.out::println);
        //synchronized (ThreadPractice.class){};


    }

}

