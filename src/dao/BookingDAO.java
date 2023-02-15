/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import model.Booking;

/**
 *
 * @author Monkay
 */
public class BookingDAO extends DAO{
    public Booking addBooking(Booking booking){
        String sql="INSERT INTO booking(book_day,client_id,employee_id) values(?,?,?)";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, sdf.format(booking.getBookDay()));
            ps.setInt(2, booking.getClient().getId());
            ps.setInt(3, booking.getEmployee().getId());
            ps.executeUpdate();
            ResultSet generatedKey=ps.getGeneratedKeys();
            if(generatedKey.next()){
                booking.setId(generatedKey.getInt(1));
            }
        } catch (Exception e) {
        }
        return booking;
    }
}
