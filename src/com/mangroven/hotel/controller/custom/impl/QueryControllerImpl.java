/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.QueryController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.QueryDAO;
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
public class QueryControllerImpl implements QueryController{
     private QueryDAO query;

    public QueryControllerImpl() {
        query=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUEARY);
    }

     
    @Override
    public boolean add(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public ArrayList<ReservationDTO> getRserveRoom(String in, String out) {
        return query.getRserveRoom(in, out);}

    @Override
    public ArrayList<PaymentDTO> gidPayment(String id) {
        return query.gidPayment(id);}

    @Override
    public ArrayList<Order_DetailDTO> getOrderDetail(String oid) {
        return query.getOrderDetail(oid);}

    @Override
    public ArrayList<FoodDTO> getPackageDetail(String pid) {
        return query.getPackageDetail(pid); }

    @Override
    public ArrayList<PaymentDTO> searchAllPayment(String id) {
        return query.searchAllPayment(id);}

    @Override
    public ArrayList<ReservationDTO> getTodayList(String in, String out) {
        return query.getTodayList(in,out);
    }
}
