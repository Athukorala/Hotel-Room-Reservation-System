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
public class Reserve_Package_DetailDTO extends SuperDTO {
    private String RsID;
    private String PID;
    private String Date;
    private String Period;

    public Reserve_Package_DetailDTO() {
    }

    public Reserve_Package_DetailDTO(String RsID, String PID, String Date, String Period) {
        this.RsID = RsID;
        this.PID = PID;
        this.Date = Date;
        this.Period = Period;
    }

    /**
     * @return the RsID
     */
    public String getRsID() {
        return RsID;
    }

    /**
     * @param RsID the RsID to set
     */
    public void setRsID(String RsID) {
        this.RsID = RsID;
    }

    /**
     * @return the PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(String PID) {
        this.PID = PID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the Period
     */
    public String getPeriod() {
        return Period;
    }

    /**
     * @param Period the Period to set
     */
    public void setPeriod(String Period) {
        this.Period = Period;
    }
    
    
    
}
