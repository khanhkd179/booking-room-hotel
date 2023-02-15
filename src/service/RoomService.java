/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.RoomDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Room;

/**
 *
 * @author Monkay
 */
public class RoomService {
    public List<Room> getRoomList(){
        RoomDAO roomDao=new RoomDAO();
        return roomDao.getRooms();
    }
    public Room getRoomById(int id){
        RoomDAO roomDao=new RoomDAO();
        return roomDao.getRoomById(id);
    }
    public boolean updateRoom(Room room){
        return RoomDAO.updateRoom(room);
    }
    public List<Room> searchFreeRoom(Date checkin,Date checkout){
        RoomDAO roomDao=new RoomDAO();
        return roomDao.searchFreeRoom(checkin, checkout);
    }
}
