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
public class Food_PackageDTO extends SuperDTO {
    private String PID;
    private String Package_Name;
    private double Package_Price;
    private ArrayList<Food_Package_DetailDTO> detail;
    

    public Food_PackageDTO(String PID, String Package_Name, double Package_Price, ArrayList<Food_Package_DetailDTO> detail) {
        this.PID = PID;
        this.Package_Name = Package_Name;
        this.Package_Price = Package_Price;
        this.detail = detail;
    }
    

    public Food_PackageDTO() {
    }

    public Food_PackageDTO(String PID, String Package_Name, double Package_Price) {
        this.PID = PID;
        this.Package_Name = Package_Name;
        this.Package_Price = Package_Price;
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
     * @return the Package_Name
     */
    public String getPackage_Name() {
        return Package_Name;
    }

    /**
     * @param Package_Name the Package_Name to set
     */
    public void setPackage_Name(String Package_Name) {
        this.Package_Name = Package_Name;
    }

    /**
     * @return the Package_Price
     */
    public double getPackage_Price() {
        return Package_Price;
    }

    /**
     * @param Package_Price the Package_Price to set
     */
    public void setPackage_Price(double Package_Price) {
        this.Package_Price = Package_Price;
    }

    /**
     * @return the detail
     */
    public ArrayList<Food_Package_DetailDTO> getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(ArrayList<Food_Package_DetailDTO> detail) {
        this.detail = detail;
    }
    
    
    
}
