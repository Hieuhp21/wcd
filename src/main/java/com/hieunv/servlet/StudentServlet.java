package com.hieunv.servlet;

import com.hieunv.entity.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StudentServlet",value="/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add_student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String className = req.getParameter("className");

        student student = new student(name, address, phone, className);

        Cookie cookie = new Cookie("student", student.toCookieValue());
        System.out.println("a:"+ student.toCookieValue());
        cookie.setMaxAge(30000);
        resp.addCookie(cookie);
        req.getRequestDispatcher("display_student.jsp").forward(req, resp);
    }
}
