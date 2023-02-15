/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Room;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import model.Type;

/**
 *
 * @author Monkay
 */
public class RoomDAO extends DAO {
    

    public static boolean updateRoom(Room room) {
        String sql = "UPDATE room SET type_id=?, price=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, room.getType().getId());
            ps.setFloat(2, room.getPrice());
            ps.setInt(3, room.getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;
    }

    public RoomDAO() {
        super();
    }

    public List<Room> getRooms() {
        List<Room> result = new ArrayList<Room>();
        String sql = "SELECT * FROM room";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                Type type = (new TypeDAO()).getTypeById(rs.getInt("type_id"));
                room.setType(type);
                room.setPrice(rs.getFloat("price"));
                result.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Room getRoomById(int id) {
        Room result = new Room();
        String sql = "SELECT * FROM room where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                Type type = (new TypeDAO()).getTypeById(rs.getInt("type_id"));
                result.setType(type);
                result.setPrice(rs.getFloat("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Room> searchFreeRoom(Date checkin, Date checkout){
    List<Room> result = new ArrayList<Room>();
    String sql = "SELECT * FROM room WHERE id NOT IN (SELECT id FROM booked_room WHERE check_out > ? AND check_in < ?)";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(checkin));
        ps.setString(2, sdf.format(checkout));
        ResultSet rs = ps.executeQuery();
 
        while(rs.next()){
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setName(rs.getString("name"));
            Type type = (new TypeDAO()).getTypeById(rs.getInt("type_id"));
            room.setType(type);
            room.setPrice(rs.getFloat("price"));
            result.add(room);
        }
    }catch(Exception e){
        e.printStackTrace();
    }   
    return result;
}
}
