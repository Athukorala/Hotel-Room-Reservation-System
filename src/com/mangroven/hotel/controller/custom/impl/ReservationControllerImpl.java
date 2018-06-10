/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.controller.custom.ReservationController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.PaymentDAO;
import com.mangroven.hotel.dao.custom.ReservationDAO;
import com.mangroven.hotel.dao.custom.impl.ReservationDAOImpl;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.ReservationDTO;
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
public class ReservationControllerImpl implements ReservationController {

    private ReservationDAO res;
    private Connection conn;
    private PaymentDAO pay;

    public ReservationControllerImpl() {
        pay = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        res = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReservationControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(ReservationDTO dto) throws Exception {
        conn.setAutoCommit(false);
        return res.add(dto);
    }

    @Override
    public boolean update(ReservationDTO dto) throws Exception {
         conn.setAutoCommit(false);
        return res.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return res.delete(id);
    }

    @Override
    public ReservationDTO search(String id) throws Exception {
        return res.search(id);
    }

    @Override
    public ArrayList<ReservationDTO> getAllID() throws Exception {
        return res.getAllID();

    }

    @Override
    public ArrayList<ReservationDTO> getAllName() throws Exception {
        return res.getAllName();
    }

    @Override
    public ArrayList<ReservationDTO> book(String rid) {
        return res.book(rid);
    }

    @Override
    public boolean deleteReservarionAndPayment(String rsid, String pyid) {
        System.out.println(rsid + " " + pyid);
        try {
            conn.setAutoCommit(false);
            boolean delete = res.delete(rsid);
            System.out.println("reservation " + delete);
            if (delete) {
                boolean okDelete = pay.delete(pyid);
                System.out.println("payment " + okDelete);
                if (okDelete) {
                    conn.commit();
                    return true;
                }
            }
            conn.rollback();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReservationControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<ReservationDTO> fillForm(String gid) {
         return res.fillForm(gid);
    }

}
