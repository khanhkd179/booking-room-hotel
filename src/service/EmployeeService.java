/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.EmployeeDAO;
import model.Employee;

/**
 *
 * @author Monkay
 */
public class EmployeeService {
    public boolean checkLogin(Employee employee){
        EmployeeDAO employeeDao=new EmployeeDAO();
        return employeeDao.checkLogin(employee);
    }
}
