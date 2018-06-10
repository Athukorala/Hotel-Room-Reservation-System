/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.ReservationDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface ReservationDAO extends SuperDAO<ReservationDTO>{
    
    public ArrayList<ReservationDTO>  date(String in,String out);

    public ArrayList<ReservationDTO> book(String rid);
    
    public ArrayList<ReservationDTO> fillForm(String gid);
    //public boolean deleteReservarionAndPayment(String rsid,String rid);
}
