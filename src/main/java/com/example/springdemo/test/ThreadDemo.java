package com.example.springdemo.test;


import java.util.concurrent.*;

class T1 implements Runnable{
    @Override
    public void run() {
        // 线程要执行的代码
        System.out.println("Thread One is running:"+Thread.currentThread().getName());
    }
}

class T2 implements Runnable{
    @Override
    public void run() {
        // 线程要执行的代码
        System.out.println("Thread Two is running:"+Thread.currentThread().getName());
    }
}

class T3 implements Runnable{
    @Override
    public void run() {
        // 线程要执行的代码
        System.out.println("Thread Three is running:"+Thread.currentThread().getName());
    }
}
public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //按顺序执行线程
        for (int i = 0; i < 10; i++) {
            //CompletableFuture<Void> run = CompletableFuture.runAsync(() -> new T3().run()).thenRun(() -> new T1().run()).thenRun(() -> new T2().run());
            //run.get();
        }

/*        CountDownLatch latch = new CountDownLatch(3);
        Runnable task = () -> {
            try {
                System.out.println("执行任务:"+Thread.currentThread().getName());
            } finally {
                latch.countDown(); // 任务完成，计数器减一
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        latch.await(); // 等待所有任务完成
        System.out.println("所有任务都完成了");*/

        ExecutorService fixedPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            fixedPool.submit(new T1());
            fixedPool.submit(new T2());
            fixedPool.submit(new T3());
            try {
                // 模拟任务执行时间
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        fixedPool.shutdown();
    }

}
