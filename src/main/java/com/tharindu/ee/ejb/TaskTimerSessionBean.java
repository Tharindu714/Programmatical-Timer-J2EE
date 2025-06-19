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
        try {
            TimerConfig timerConfig = new TimerConfig();
            String taskId = UUID.randomUUID().toString();

            Task task = new Task(taskId, "Task Name", "Task Description");
            timerConfig.setInfo(task);

            ScheduleExpression scheduleExpression = new ScheduleExpression();

            scheduleExpression.hour("*"); // Every hour
            scheduleExpression.minute("*"); // Every minute
            scheduleExpression.second("*/10"); // Every 10 seconds
            timerService.createCalendarTimer(scheduleExpression, timerConfig);

//            scheduleExpression.dayOfWeek("THU"); // Thursday
//            scheduleExpression.dayOfMonth("17"); // 17th of the month
//            scheduleExpression.hour("16"); // 4 PM
//            scheduleExpression.minute("23-25"); // Between 23 and 25 minutes
//            scheduleExpression.second("10"); // 10 seconds

//            scheduleExpression.dayOfWeek("3-5"); // Tuesday to Thursday
//            scheduleExpression.dayOfWeek("MON-FRI"); // Monday to Friday
//            scheduleExpression.dayOfMonth("L"); // Thursday

//        scheduleExpression.hour("16,17,18");
//        scheduleExpression.minute("10,15,25");
//        scheduleExpression.second("*/5,11");

//        scheduleExpression.hour("16-17"); // Between 4 PM and 5 PM
//        scheduleExpression.minute("01-05"); // Between 01 and 05 minutes
//        scheduleExpression.second("10-20"); // Between 10 and 20 seconds

//        scheduleExpression.hour(8);
//        scheduleExpression.minute(51);
//        scheduleExpression.second(10);

//        timerService.createSingleActionTimer(time, timerConfig);

            return task;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
