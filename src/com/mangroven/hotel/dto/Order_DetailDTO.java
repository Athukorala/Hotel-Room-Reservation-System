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
public class Order_DetailDTO extends SuperDTO {

    private String oid;
    private String pid;
    private int qty;
    private String package_name;
    private double price;

    public Order_DetailDTO() {
    }

    public Order_DetailDTO(String oid, String pid, int qty) {
        this.oid = oid;
        this.pid = pid;
        this.qty = qty;
    }

    public Order_DetailDTO(String oid) {
        this.oid = oid;
    }

    public Order_DetailDTO(String pid, String package_name, int qty, double price) {
        this.oid = oid;
        this.pid = pid;
        this.qty = qty;
        this.package_name=package_name;
        this.price=price;
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
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the package_name
     */
    public String getPackage_name() {
        return package_name;
    }

    /**
     * @param package_name the package_name to set
     */
    public void setPackage_name(String package_name) {
        this.package_name = package_name;
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
