package com.tharindu.ee.timer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;
    Timer timer;

    public void doTask() {

        timer = timerService.createTimer(10000, "Clock"); // Create a timer that triggers after 1 second
    //  timerService.createIntervalTimer(1000, 5000, new TimerConfig()); // Create a timer that triggers every 5 seconds
    }

    @Timeout
    public void timeOutTask() {
        System.out.println("OK... Timer triggered on thread: " + Thread.currentThread().getName());
    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            System.out.println("Timer cancelled on thread: " + Thread.currentThread().getName());
        } else {
            System.out.println("No timer to cancel on thread: " + Thread.currentThread().getName());
        }
    }
}
