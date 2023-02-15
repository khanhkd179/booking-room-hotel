/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Monkay
 */
public class BookedRoom implements Serializable{
    private int id;
    private Date checkin;
    private Date checkout;
    private float price;
    private Room room;

    public BookedRoom() {
    }

    public BookedRoom(int id, Date checkin, Date checkout, float price, Room room) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.price = price;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "BookedRoom{" + "id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + ", price=" + price + ", room=" + room + '}';
    }
    
    
}
