/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dto;

/**
 *
 * @author Athukorala
 */
public class CostDTO extends SuperDTO{
    private String costID;
    private String description;
    private double cost;
    private String payid;
    private String date;
    private String time;
    
    

    public CostDTO() {
    }

    public CostDTO(String costID, String description, double cost, String payid,String date,String time) {
        this.costID = costID;
        this.description = description;
        this.cost = cost;
        this.payid = payid;
        this.date=date;
        this.time=time;
    }
    public CostDTO(String costID, String description, double cost,String date,String time) {
        this.costID = costID;
        this.description = description;
        this.cost = cost;
        this.payid = payid;
        this.date=date;
        this.time=time;
    }
  

    /**
     * @return the costID
     */
    public String getCostID() {
        return costID;
    }

    /**
     * @param costID the costID to set
     */
    public void setCostID(String costID) {
        this.costID = costID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     * @return the payid
     */
    public String getPayid() {
        return payid;
    }

    /**
     * @param payid the payid to set
     */
    public void setPayid(String payid) {
        this.payid = payid;
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
    
    
}
