/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.*;
import java.util.List;
import model.Type;

/**
 *
 * @author Monkay
 */
public class TypeService {
    public List<Type> getTypeList(){
        TypeDAO typeDao=new TypeDAO();
        return typeDao.getTypes();
        
    }
}
