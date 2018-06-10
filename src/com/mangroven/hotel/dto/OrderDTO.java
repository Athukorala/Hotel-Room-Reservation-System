/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dto;

import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public class OrderDTO extends SuperDTO{
     private String oid;
    private String rsid;
    private String date ;
    private String period ;
    private double price ;
    private ArrayList<Order_DetailDTO> odList;

    public OrderDTO() {
    }

    public OrderDTO(String oid, String rsid, String date, String period, double price, ArrayList<Order_DetailDTO> odList) {
        this.oid = oid;
        this.rsid = rsid;
        this.date = date;
        this.period = period;
        this.price = price;
        this.odList = odList;
    }

    public OrderDTO(String oid, String rsid, String date, String period, double price) {
        this.oid = oid;
        this.rsid = rsid;
        this.date = date;
        this.period = period;
        this.price = price;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the rsid
     */
    public String getRsid() {
        return rsid;
    }

    /**
     * @param rsid the rsid to set
     */
    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
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

    /**
     * @return the odList
     */
    public ArrayList<Order_DetailDTO> getOdList() {
        return odList;
    }

    /**
     * @param odList the odList to set
     */
    public void setOdList(ArrayList<Order_DetailDTO> odList) {
        this.odList = odList;
    }
    
    
}
