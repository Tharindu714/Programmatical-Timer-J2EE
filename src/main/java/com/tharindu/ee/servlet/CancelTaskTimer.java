package com.tharindu.ee.servlet;

import com.tharindu.ee.ejb.TaskTimerSessionBean;
import com.tharindu.ee.timer.Task;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cancel_Task_Timer")
public class CancelTaskTimer extends HttpServlet {
    @EJB
    TaskTimerSessionBean taskTimerSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("task") != null) {
            Task task = (Task) request.getSession().getAttribute("task");
            taskTimerSessionBean.cancelTimer(task.getTaskId());
        }
    }
}
