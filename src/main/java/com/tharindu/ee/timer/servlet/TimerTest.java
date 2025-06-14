package com.tharindu.ee.timer.servlet;

import com.tharindu.ee.timer.ejb.TimerNewSessionBean;
import com.tharindu.ee.timer.ejb.TimerSessionBean;
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
    TimerNewSessionBean timerNewSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        timerSessionBean.doTask();
        timerNewSessionBean.doTask();
    }
}
