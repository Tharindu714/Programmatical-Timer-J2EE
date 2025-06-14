package com.tharindu.ee.timer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Stateless
public class TaskSessionBean {
    @Resource
    ManagedExecutorService executorService;

//    public void do_task() {
    public Future<String> do_task() {
        // Implementation of the task
        System.out.println("Task executed..." + Thread.currentThread().getName());

        return executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task running: " + i + " on thread: " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Task completed: " + i + " on thread: " + Thread.currentThread().getName());
                }
                return "Task completed successfully";
            }
        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("Task running: " + i + " on thread: " + Thread.currentThread().getName());
//
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("Task completed: " + i + " on thread: " + Thread.currentThread().getName());
//                }
//            }
//        });
    }
}
