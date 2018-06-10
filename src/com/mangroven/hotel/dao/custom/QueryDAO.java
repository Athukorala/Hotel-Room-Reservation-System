/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.FoodDTO;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import com.mangroven.hotel.dto.PaymentDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface QueryDAO extends SuperDAO<SuperDTO> {

    @Override
    public default boolean add(SuperDTO dto) throws Exception {
        return true;
    }

    @Override
    public default SuperDTO search(String id) throws Exception {
        return null;
    }

    @Override
    public default ArrayList<SuperDTO> getAllName() throws Exception {
        return null;
    }

    @Override
    public default ArrayList<SuperDTO> getAllID() throws Exception {
        return null;
    }

    @Override
    public default boolean delete(String key) throws Exception {
        return true;
    }

    @Override
    public default boolean update(SuperDTO dto) throws Exception {
        return true;
    }

    public ArrayList<PaymentDTO> gidPayment(String id);

    public ArrayList<ReservationDTO> getRserveRoom(String in, String out);

    public ArrayList<Order_DetailDTO> getOrderDetail(String oid);
    
    public ArrayList<FoodDTO> getPackageDetail(String pid);
    
    public ArrayList<PaymentDTO> searchAllPayment(String id);
    
    public ArrayList<ReservationDTO> getTodayList(String in, String out);
   
}
