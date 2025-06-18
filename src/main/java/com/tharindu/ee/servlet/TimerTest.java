package com.tharindu.ee.servlet;

import com.tharindu.ee.ejb.TaskTimerSessionBean;
import com.tharindu.ee.ejb.TimerNewSessionBean;
import com.tharindu.ee.timer.Task;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/timer_test")
public class TimerTest extends HttpServlet {
    @EJB
//    TimerSessionBean timerSessionBean;
//    TimerNewSessionBean timerNewSessionBean;
    TaskTimerSessionBean taskTimerSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        timerSessionBean.doTask();
//        timerNewSessionBean.doTask();

        Task task = taskTimerSessionBean.doTask(20000); // 20 ms
        System.out.println("Task is scheduled with ID: " + task.getTaskId());

        request.getSession().setAttribute("task", task.getTaskId());
    }
}
