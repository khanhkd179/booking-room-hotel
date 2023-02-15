/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Type;

/**
 *
 * @author Monkay
 */
public class TypeDAO extends DAO {

    public TypeDAO() {
        super();
    }

    public Type getTypeById(int id) {
        Type result = new Type();
        String sql = "SELECT * FROM type where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Type> getTypes() {
        List<Type> result = new ArrayList<Type>();
        String sql = "SELECT * FROM type";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                result.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
