package com.tharindu.ee.timer;

import java.io.Serializable;

public class Task implements Serializable {
    private final String taskId;
    private final String taskName;
    private final String taskDescription;

    public Task(String taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}
