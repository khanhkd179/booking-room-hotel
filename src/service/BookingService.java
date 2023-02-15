/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.BookedRoomDAO;
import dao.BookingDAO;
import java.util.List;
import model.BookedRoom;
import model.Booking;

/**
 *
 * @author Monkay
 */
public class BookingService {
    BookingDAO bookingDao=new BookingDAO();
    BookedRoomDAO bookedRoomDao=new BookedRoomDAO();
    public void addBooking(Booking booking,List<BookedRoom> listBookedRoom){
        booking = bookingDao.addBooking(booking);
        for(BookedRoom br:listBookedRoom){
            bookedRoomDao.addBookedRoom(br, booking);
        }
        
    }
}
