/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.PaymentDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface PaymentController extends SuperController<PaymentDTO> {
     public ArrayList<PaymentDTO> rsidPayment(String id);
     
     public PaymentDTO searchId(String rsid,String rid);
     
     public PaymentDTO searchId(String oid);
     
     
    public boolean deleteRoom(String rsid,String rid);
    
    public boolean deleteOrder(String oid);

    @Override
    public default boolean add(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean added(String pyid,String costId,double cost,String date,String time);
    
    public ArrayList<PaymentDTO> getAllNameS();
    
    
    public PaymentDTO getProfit();
     
    
}
