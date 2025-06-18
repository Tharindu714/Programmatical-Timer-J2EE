package com.tharindu.ee.ejb;

import com.tharindu.ee.timer.Task;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.io.Serializable;
import java.util.UUID;

@Stateless
public class TaskTimerSessionBean {
    @Resource
    private TimerService timerService;

    public Task doTask(long time) {

        TimerConfig timerConfig = new TimerConfig();
        String taskId = UUID.randomUUID().toString();

        Task task = new Task(taskId, "Task Name", "Task Description");
        timerConfig.setInfo(task);

        ScheduleExpression scheduleExpression = new ScheduleExpression();
        timerService.createCalendarTimer(scheduleExpression,timerConfig);

//        timerService.createSingleActionTimer(time, timerConfig);

        return task;
    }

    @Timeout
    public void timeOutTask(Timer timer) {
        Serializable info = timer.getInfo();
        if (info instanceof Task) {
            Task task = (Task) info;
            System.out.println("Timer triggered: " + timer);
        }
    }

    public void cancelTimer(String taskId) {
        for (Timer timer : timerService.getTimers()) {
            if (timer.getInfo() instanceof Task && ((Task) timer.getInfo()).getTaskId().equals(taskId)) {
                timer.cancel();
                System.out.println(taskId + " has been cancelled.");
                break;
            }
        }
    }
}
