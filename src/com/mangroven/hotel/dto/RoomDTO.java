/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dto;

/**
 *
 * @author tharindu
 */
public class RoomDTO extends SuperDTO {
    private String RID;
    private String Room_Name;
    private String Room_Description;
    private double Room_Price;

    public RoomDTO() {
    }

    public RoomDTO(String RID, String Room_Name, String Room_Description, double Room_Price) {
        this.RID = RID;
        this.Room_Name = Room_Name;
        this.Room_Description = Room_Description;
        this.Room_Price = Room_Price;
    }

    public RoomDTO(String RID) {
        this.RID = RID;
    }

    /**
     * @return the RID
     */
    public String getRID() {
        return RID;
    }

    /**
     * @param RID the RID to set
     */
    public void setRID(String RID) {
        this.RID = RID;
    }

    /**
     * @return the Room_Name
     */
    public String getRoom_Name() {
        return Room_Name;
    }

    /**
     * @param Room_Name the Room_Name to set
     */
    public void setRoom_Name(String Room_Name) {
        this.Room_Name = Room_Name;
    }

    /**
     * @return the Room_Description
     */
    public String getRoom_Description() {
        return Room_Description;
    }

    /**
     * @param Room_Description the Room_Description to set
     */
    public void setRoom_Description(String Room_Description) {
        this.Room_Description = Room_Description;
    }

    /**
     * @return the Room_Price
     */
    public double getRoom_Price() {
        return Room_Price;
    }

    /**
     * @param Room_Price the Room_Price to set
     */
    public void setRoom_Price(double Room_Price) {
        this.Room_Price = Room_Price;
    }
    
}
