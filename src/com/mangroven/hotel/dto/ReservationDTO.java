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
public class ReservationDTO extends SuperDTO {
    private String rsid;
    private String gid;
    private String rid;
    private int persons;
    private String check_In;
    private String check_Out;
    private double price;

    public ReservationDTO() {
    }

    public ReservationDTO(String rsID, String gID, String rID, int persons, String check_In, String check_Out, double price) {
        this.rsid = rsID;
        this.gid = gID;
        this.rid = rID;
        this.persons = persons;
        this.check_In = check_In;
        this.check_Out = check_Out;
        this.price = price;
    }

  

   

    public ReservationDTO(String check_In, String check_Out) {
        this.check_In = check_In;
        this.check_Out = check_Out;
    }

    public ReservationDTO(String rsid, String gid, String rid, int persons) {
         this.rsid = rsid;
        this.gid = gid;
        this.rid = rid;
        this.persons = persons;
        this.check_In = check_In;
        this.check_Out = check_Out;}

    public ReservationDTO(String rid) {
        this.rid=rid;
    }

    /**
     * @return the rsID
     */
    public String getRsID() {
        return rsid;
    }

    /**
     * @param rsID the rsID to set
     */
    public void setRsID(String rsID) {
        this.rsid = rsID;
    }

    /**
     * @return the gID
     */
    public String getgID() {
        return gid;
    }

    /**
     * @param gID the gID to set
     */
    public void setgID(String gID) {
        this.gid = gID;
    }

    /**
     * @return the rID
     */
    public String getrID() {
        return rid;
    }

    /**
     * @param rID the rID to set
     */
    public void setrID(String rID) {
        this.rid = rID;
    }

    /**
     * @return the persons
     */
    public int getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(int persons) {
        this.persons = persons;
    }

    /**
     * @return the check_In
     */
    public String getCheck_In() {
        return check_In;
    }

    /**
     * @param check_In the check_In to set
     */
    public void setCheck_In(String check_In) {
        this.check_In = check_In;
    }

    /**
     * @return the check_Out
     */
    public String getCheck_Out() {
        return check_Out;
    }

    /**
     * @param check_Out the check_Out to set
     */
    public void setCheck_Out(String check_Out) {
        this.check_Out = check_Out;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    

  
}
