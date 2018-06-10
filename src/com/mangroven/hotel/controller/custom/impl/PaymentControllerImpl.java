/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.controller.custom.PaymentController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.PaymentDAO;
import com.mangroven.hotel.dao.custom.impl.PaymentDAOImpl;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.PaymentDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class PaymentControllerImpl implements PaymentController {

    private PaymentDAO pay;
    private Connection conn;

    public PaymentControllerImpl() {
        pay = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Override
    public boolean add(PaymentDTO dto) throws Exception {
        try{
        return pay.add(dto);
        }finally{
            conn.setAutoCommit(false);
            conn.commit();
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        try{
        return pay.update(dto);
        }finally{
            conn.setAutoCommit(false);
            conn.commit();
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
       return pay.delete(id);
    }

    @Override
    public PaymentDTO search(String id) throws Exception {
        return pay.search(id);
    }

    @Override
    public ArrayList<PaymentDTO> getAllID() throws Exception {
       return pay.getAllID();
    }

    @Override
    public ArrayList<PaymentDTO> getAllName() throws Exception {
       return pay.getAllName();
    }

    @Override
    public ArrayList<PaymentDTO> rsidPayment(String id) {
        return pay.rsidPayment(id);}

    @Override
    public PaymentDTO searchId(String rsid, String rid) {
        return pay.searchId(rsid,rid);}

    @Override
    public PaymentDTO searchId(String oid) {
        return pay.searchId(oid);}

    @Override
    public boolean deleteOrder(String oid) {
        return pay.deleteOrder(oid);}

    @Override
    public boolean deleteRoom(String rsid, String rid) {
        return pay.deleteRoom(rsid,rid);
    }

   
    @Override
    public boolean added(String pyid, String costId, double cost, String date, String time) {
        return pay.added(pyid, costId, cost, date, time);
    }

    @Override
    public ArrayList<PaymentDTO> getAllNameS() {
        return pay.getAllNameS();
    }

    @Override
    public PaymentDTO getProfit() {
        return pay.getProfit();}


   

}
