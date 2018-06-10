/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dto;

import static java.util.Calendar.DATE;
import java.util.Date;

/**
 *
 * @author tharindu
 */
public class GuestDTO extends SuperDTO {
    private String GID;
    private String Name;
    private String Address;
    private String Tel;
    private String Email;
    private String Country;
    private String Gender;
    private String DOB;
    private String nic;
    private String passport;
    

    public GuestDTO() {
    }

    public GuestDTO(String GID, String Name, String Address, String Tel, String Email, String Country, String Gender, String DOB, String nic, String passport) {
        this.GID = GID;
        this.Name = Name;
        this.Address = Address;
        this.Tel = Tel;
        this.Email = Email;
        this.Country = Country;
        this.Gender = Gender;
        this.DOB = DOB;
        this.nic = nic;
        this.passport = passport;
    }

    public GuestDTO(String GID, String Name, String Address, String Tel, String Email, String Country, String Gender, String DOB) {
        this.GID = GID;
        this.Name = Name;
        this.Address = Address;
        this.Tel = Tel;
        this.Email = Email;
        this.Country = Country;
        this.Gender = Gender;
        this.DOB = DOB;
    }

    public GuestDTO(String gid, String nic, String passport) {
        this.GID=gid;
        this.nic=nic;
        this.passport=passport;
    }

    
    /**
     * @return the GID
     */
    public String getGID() {
        return GID;
    }

    /**
     * @param GID the GID to set
     */
    public void setGID(String GID) {
        this.GID = GID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    
    
}