package com.tharindu.ee.timer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.util.Collection;

@Singleton
public class TimerNewSessionBean {

    @Resource
    private TimerService timerService;
//    Timer timer;

    public void doTask() {

        timerService.createTimer(10000, "Clock"); // Create a timer that triggers after 1 second

        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("Info");

        timerService.createSingleActionTimer(10000, timerConfig);

        Collection<Timer> allTimers = timerService.getAllTimers();
        allTimers.forEach(timer -> {
            System.out.println("Timer info: " + timer.getInfo());
            System.out.println("Timer next timeout: " + timer.getNextTimeout());

//            if(timer instanceof User user && user.id.e) {
//                ((Timer)timer).cancel();
//            }
        });
    }

    @Timeout
    public void timeOutTask(Timer timer) {
        System.out.println("Timer triggered: " + timer);
    }

}
