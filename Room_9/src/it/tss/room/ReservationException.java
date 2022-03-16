/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.room;

/**
 *
 * @author tss
 */
public class ReservationException extends Exception {
    
    private final Room.Reservation r;

    public ReservationException(Room.Reservation r, String msg) {
        super(msg);
        this.r = r;
    }

    public Room.Reservation getR() {
        return r;
    }
    
    
    
    
}
