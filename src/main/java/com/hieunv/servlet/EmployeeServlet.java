package com.hieunv.servlet;

import com.hieunv.entity.employee;
import com.hieunv.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="EmployeeServlet",value="/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService= new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req, resp);
    }
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        if(action==null){
            List<employee> employees= employeeService.getEmployees();
            req.setAttribute("employees",employees);
            req.getRequestDispatcher("employee_list.jsp").forward(req,resp);
        }else if (action.equals("delete")) {
            String empNo = req.getParameter("empNo");
            System.out.println("Emp no: " + empNo);
            employeeService.deleteEmp(empNo);
            resp.sendRedirect("/EmployeeServlet");
        } else if (action.equals("add")) {
            employee employee = new employee();
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("add_employee.jsp").forward(req, resp);
        } else if(action.equals("create")) {
            String empNo = req.getParameter("empNo");
            String empName = req.getParameter("empName");
            String empPlace = req.getParameter("empPlace");
            String empPhone = req.getParameter("empPhone");
            boolean exist = employeeService.checkExist(empNo);
            if (exist) {
                employee employee = new employee();
                employee.setEmployeeNo(empNo);
                employee.setEmployeeName(empName);
                employee.setPlaceOfWork(empPlace);
                employee.setPhoneNo(empPhone);
                req.setAttribute("errMsg", "This employee existed, Please try other");
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("add_employee.jsp").forward(req, resp);
            } else {
                employeeService.addEmployee(empNo, empName, empPlace, empPhone);
                resp.sendRedirect("/EmployeeServlet");
            }
        }
    }
}
