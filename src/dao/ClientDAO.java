/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Client;

/**
 *
 * @author Monkay
 */
public class ClientDAO extends DAO{
    public Client searchClient(String tel){
        Client result=new Client();
        String sql="SELECT * FROM client where tel=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setAddress(rs.getString("address"));
                result.setFullName(rs.getString("full_name"));
                result.setEmail(rs.getString("email"));
                result.setTel(rs.getString("tel"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;  
    }
    public Client addClient(Client client){
        String sql="INSERT INTO client(full_name,email,address,tel) values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFullName());
            ps.setString(2,client.getEmail());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getTel());
            ps.executeUpdate();
            ResultSet generatedKey=ps.getGeneratedKeys();
            if(generatedKey.next()){
                client.setId(generatedKey.getInt(1));
            }
        } catch (Exception e) {
        }
        return client;
    }
}
