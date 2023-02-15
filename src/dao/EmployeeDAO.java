/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Monkay
 */
public class EmployeeDAO extends DAO{

    public EmployeeDAO() {
        super();
    }
    public boolean checkLogin(Employee employee) {
        boolean result = false;
        String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setFullName(rs.getString("full_name"));
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
