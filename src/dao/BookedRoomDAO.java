/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import model.BookedRoom;
import model.Booking;
import model.Room;

/**
 *
 * @author Monkay
 */
public class BookedRoomDAO extends DAO{
    public void addBookedRoom(BookedRoom bookedRoom,Booking booking){
        String sql="INSERT INTO booked_room(check_in,check_out,price,booking_id,room_id) values(?,?,?,?,?)";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(bookedRoom.getCheckin()));
            ps.setString(2, sdf.format(bookedRoom.getCheckout()));
            ps.setFloat(3, bookedRoom.getPrice());
            ps.setInt(4, booking.getId());
            ps.setInt(5, bookedRoom.getRoom().getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
