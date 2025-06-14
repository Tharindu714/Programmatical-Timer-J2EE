package com.tharindu.ee.timer.servlet;

import com.tharindu.ee.timer.ejb.TimerSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cancel_Timer")
public class CancelTimer extends HttpServlet {

    @EJB
    TimerSessionBean timerSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timerSessionBean.cancelTimer();
    }
}
