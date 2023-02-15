/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Monkay
 */
public class Booking implements Serializable{
    private int id;
    private Date bookDay;
    private float totalAmount;
    private Employee employee;
    private List<BookedRoom> listBookedRoom;
    private Client client;

    public Booking() {
    }

    public Booking(Date bookDay, float totalAmount, Employee employee, List<BookedRoom> listBookedRoom, Client client) {
        this.bookDay = bookDay;
        this.totalAmount = totalAmount;
        this.employee = employee;
        this.listBookedRoom = listBookedRoom;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookDay() {
        return bookDay;
    }

    public void setBookDay(Date bookDay) {
        this.bookDay = bookDay;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<BookedRoom> getListBookedRoom() {
        return listBookedRoom;
    }

    public void setListBookedRoom(List<BookedRoom> listBookedRoom) {
        this.listBookedRoom = listBookedRoom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
