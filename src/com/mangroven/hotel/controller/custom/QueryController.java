/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dao.custom.PaymentDAO;
import com.mangroven.hotel.dto.FoodDTO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import com.mangroven.hotel.dto.PaymentDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface QueryController extends SuperController<SuperDTO> {

    public ArrayList<PaymentDTO> gidPayment(String id);

    public ArrayList<ReservationDTO> getRserveRoom(String in, String out);
    
    public ArrayList<Order_DetailDTO> getOrderDetail(String oid);
    
    public ArrayList<FoodDTO> getPackageDetail(String pid);
    
    public ArrayList<PaymentDTO> searchAllPayment(String id);
    
    public ArrayList<ReservationDTO> getTodayList(String in, String out);
}
