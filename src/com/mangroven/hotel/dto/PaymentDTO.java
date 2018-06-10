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
public class PaymentDTO extends SuperDTO {
    private String pyid;
    private String rsid;
    private String rid;
  
    private String oid;
    private String costid;
    private String date;
    private String time;
    private double cost;
    private double amount;
    private double advance;
    private double newAmount;

    public PaymentDTO() {
    }
    
    public PaymentDTO(String pyid,String costid, double cost){
        this.costid=costid;
        this.cost=cost;
        this.pyid=pyid;
    }
    
    public PaymentDTO(String pyid, String rsid, String rid, String oid, String costid, String date, String time, double cost, double amount, double advance) {
        this.pyid = pyid;
        this.rsid = rsid;
        this.rid = rid;
        this.oid = oid;
        this.costid = costid;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.amount = amount;
        this.advance = advance;
       
    }
    
    public PaymentDTO(String pyid, String rsid, String rid, String oid, String date, String time, double amount, double advance) {
        this.pyid = pyid;
        this.rsid = rsid;
        this.rid = rid;
        this.oid = oid;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.advance = advance;
    }

    public PaymentDTO(double amount) {
        this.amount=amount;
    }

    public PaymentDTO(double amount, double advance, double aaa) {
       this.amount=amount;
       this.advance=advance;
       this.newAmount=aaa;
       
    }

    public PaymentDTO(String pyid, String rsid, String rid, String oid, String date, String time, double cost, double amount, double advance) {
        this.pyid = pyid;
        this.rsid = rsid;
        this.rid = rid;
        this.oid = oid;
       
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.amount = amount;
        this.advance = advance;
       
    }
    

    /**
     * @return the pyid
     */
    public String getPyid() {
        return pyid;
    }

    /**
     * @param pyid the pyid to set
     */
    public void setPyid(String pyid) {
        this.pyid = pyid;
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
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }

    /**
     * @return the newAmount
     */
    public double getNewAmount() {
        return newAmount;
    }

    /**
     * @param newAmount the newAmount to set
     */
    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

    /**
     * @return the costid
     */
    public String getCostid() {
        return costid;
    }

    /**
     * @param costid the costid to set
     */
    public void setCostid(String costid) {
        this.costid = costid;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}

   
