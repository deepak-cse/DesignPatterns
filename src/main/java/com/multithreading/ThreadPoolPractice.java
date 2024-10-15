package com.multithreading;

import java.util.Random;
import java.util.concurrent.*;

class ProcessTask implements Runnable{

    private int id;
    ProcessTask(int id){
        this.id=id;
    }
    @Override
    public void run() {
        System.out.println("started id "+id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ended id"+id);
    }
}
public class ThreadPoolPractice {
    public static void main(String[] args) {

//        ExecutorService executors = Executors.newFixedThreadPool(2);
//
//        for(int i=0;i<10;i++) {
//            executors.submit(new ProcessTask(i));
//        }
//
//        System.out.println("All tasks submitted");

//        try {
//            executors.awaitTermination(1, TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



//        System.out.println("all task ended");


//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        Future<Integer> future= executorService.submit(new Callable<Integer>() {
//
//            @Override
//            public Integer call() throws Exception {
//                Random random = new Random();
//                Integer value = random.nextInt(100);
//                System.out.println("thread started");
//                Thread.sleep(1000);
//                System.out.println("thread ended");
//                return value;
//            }
//        });
//
//        try {
//            System.out.println("returned value " + future.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


//        //CompletableFuture<Integer> completableFuture = getValue();
//        CompletableFuture.supplyAsync(()->getValue()).thenApply(result -> {
//            System.out.println(result);
//            return result;
//        }).join();
//
//
//        System.out.println("main end");


        Thread thread = new Thread(()-> System.out.println("another thread"));

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main end");

    }


    public static int getValue(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return r.nextInt(10);
    }
}
