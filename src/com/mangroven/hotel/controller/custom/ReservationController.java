/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.ReservationDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface ReservationController extends SuperController<ReservationDTO> {


    public ArrayList<ReservationDTO> book(String rid);
    
     public boolean deleteReservarionAndPayment(String rsid,String rid);

    public ArrayList<ReservationDTO> fillForm(String gid);

}
