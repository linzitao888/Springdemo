package com.example.springdemo.test;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        Runnable task = () -> {
            int initialValue = threadLocalValue.get();
            System.out.println("Initial Value: " + initialValue);

            // Modify the value
            threadLocalValue.set(initialValue + 1);
            System.out.println("Modified Value: " + threadLocalValue.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
