package com.tharindu.ee.ejb;

import jakarta.ejb.Schedule;
import jakarta.ejb.Schedules;
import jakarta.ejb.Stateless;

@Stateless
public class AutoTimerSessionBean {
    @Schedules({
            @Schedule(hour = "17-18", minute = "10", second = "*/10", persistent = false),
            @Schedule(hour = "*", minute = "30", second = "10")
    })
    public void autoSchedule() {
        // This method can be used to trigger an automatic scheduling of tasks
        // The actual implementation would depend on the specific requirements
        // and the context in which this EJB is used.
        System.out.println("Auto-scheduling tasks...");
    }
}
