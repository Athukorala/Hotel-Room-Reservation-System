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
public class FoodDTO extends SuperDTO{
    
    private String FID;
    private String Food_Name;
    private double Unit_Price;

    public FoodDTO() {
    }

    public FoodDTO(String FID, String Food_Name, double Unit_Price) {
        this.FID = FID;
        this.Food_Name = Food_Name;
        this.Unit_Price = Unit_Price;
    }

    public FoodDTO(String FID, String Food_Name) {
        this.FID = FID;
        this.Food_Name = Food_Name;}

    /**
     * @return the FID
     */
    public String getFID() {
        return FID;
    }

    /**
     * @param FID the FID to set
     */
    public void setFID(String FID) {
        this.FID = FID;
    }

    /**
     * @return the Food_Name
     */
    public String getFood_Name() {
        return Food_Name;
    }

    /**
     * @param Food_Name the Food_Name to set
     */
    public void setFood_Name(String Food_Name) {
        this.Food_Name = Food_Name;
    }

    /**
     * @return the Unit_Price
     */
    public double getUnit_Price() {
        return Unit_Price;
    }

    /**
     * @param Unit_Price the Unit_Price to set
     */
    public void setUnit_Price(double Unit_Price) {
        this.Unit_Price = Unit_Price;
    }
    
    
}
