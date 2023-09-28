package com.hieunv.service;

import com.hieunv.entity.employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public List<employee> getEmployees(){
        EntityManager  em= Persistence.createEntityManagerFactory("employee-pu").createEntityManager();
        List<employee> employees= new ArrayList<>();
        try{
            Query query= em.createQuery("select  e from employee e");
            employees= (List<employee>)  query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
        return employees;
    }
    public void deleteEmp(String empNo) {
        EntityManager em = Persistence.createEntityManagerFactory("employee-pu").createEntityManager();
        try {
            em.getTransaction().begin();
            employee emp = em.find(employee.class, empNo);
            if (emp != null) {
                em.remove(emp);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
    public boolean checkExist(String empNo) {
        boolean exist = false;
        EntityManager em = Persistence.createEntityManagerFactory("employee-pu").createEntityManager();
        try {
            employee emp = em.find(employee.class, empNo);
            if (emp != null) {
                exist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return exist;
    }

    public void addEmployee(String empNo, String empName, String empPlace, String empPhone) {
        EntityManager em = Persistence.createEntityManagerFactory("employee-pu").createEntityManager();
        try {
            em.getTransaction().begin();
            employee employee = new employee();
            employee.setEmployeeNo(empNo);
            employee.setEmployeeName(empName);
            employee.setPlaceOfWork(empPlace);
            employee.setPhoneNo(empPhone);
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
