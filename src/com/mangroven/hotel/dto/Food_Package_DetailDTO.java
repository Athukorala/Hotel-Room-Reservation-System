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
public class Food_Package_DetailDTO extends SuperDTO {
    private String PID;
    private String FID;
    private ArrayList<Food_Package_DetailDTO> list;
    
    public Food_Package_DetailDTO() {
    }

    public Food_Package_DetailDTO(String PID, String FID) {
        this.PID = PID;
        this.FID = FID;
    }

    public Food_Package_DetailDTO(String PID, String FID, ArrayList<Food_Package_DetailDTO> list) {
        this.PID=PID;
        this.FID=FID;
        this.list=list;
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
     * @return the list
     */
    public ArrayList<Food_Package_DetailDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<Food_Package_DetailDTO> list) {
        this.list = list;
    }

    
}
