package com.tharindu.ee.servlet;

import com.tharindu.ee.ejb.TaskSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet("/test")
public class Test extends HttpServlet {
    @EJB
    TaskSessionBean taskSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Future<String> do_task = taskSessionBean.do_task();

        try {
            String s = do_task.get();
            response.getWriter().println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            response.getWriter().println("Error executing task: " + e.getMessage());
        }
    }
}
