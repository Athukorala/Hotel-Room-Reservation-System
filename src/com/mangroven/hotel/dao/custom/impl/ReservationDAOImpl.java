/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.ReservationDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.ReservationDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Date.from;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class ReservationDAOImpl implements ReservationDAO {

    private Connection conn;

    public ReservationDAOImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public boolean add(ReservationDTO c1) throws Exception {

        //System.out.println("ussss");
        String SQL = "Insert into Reservation values(?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getRsID());
        stm.setObject(2, c1.getgID());
        stm.setObject(3, c1.getrID());
        stm.setObject(4, c1.getPersons());
        stm.setObject(5, c1.getCheck_In());
        stm.setObject(6, c1.getCheck_Out());
        stm.setObject(7, c1.getPrice());
        // System.out.println("daooo");
        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(ReservationDTO c1) throws Exception {
        String SQL = "Update Reservation set GID=?, RID=?, Persons=?, Check_In=?,Check_Out=?,Price=? where RsID=?";

        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getgID());
        stm.setObject(2, c1.getrID());
        stm.setObject(3, c1.getPersons());
        stm.setObject(4, c1.getCheck_In());
        stm.setObject(5, c1.getCheck_Out());
        stm.setObject(6, c1.getPrice());
        stm.setObject(7, c1.getRsID());

        int res = stm.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Reservation where RsID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    @Override
    public ArrayList<ReservationDTO> getAllID() throws Exception {
        String SQL = "Select * From Reservation";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ReservationDTO> list = new ArrayList<>();
        while (rst.next()) {
            ReservationDTO c1 = new ReservationDTO(rst.getString("rsid"), rst.getString("gid"), rst.getString("rid"), rst.getInt("persons"), rst.getString("check_In"), rst.getString("check_Out"), rst.getDouble("price"));
            list.add(c1);
        }
        return list;
    }

    @Override
    public ArrayList<ReservationDTO> getAllName() throws Exception {
        String SQL = "Select * From Reservation";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ReservationDTO> reserveList = new ArrayList<>();
        while (rst.next()) {
            ReservationDTO c1 = new ReservationDTO(rst.getString("rsid"), rst.getString("gid"), rst.getString("rid"), rst.getInt("persons"), rst.getString("check_In"), rst.getString("check_Out"), rst.getDouble("price"));
            reserveList.add(c1);
        }
        return reserveList;
    }

    @Override
    public ReservationDTO search(String resv) throws Exception {
        String sql = "select * from Reservation where RsID='" + resv + "'  || RID='" + resv + "'";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            ReservationDTO c1 = new ReservationDTO(rst.getString("rsid"), rst.getString("gid"), rst.getString("rid"), rst.getInt("persons"), rst.getString("check_In"), rst.getString("check_Out"), rst.getDouble("price"));
            return c1;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<ReservationDTO> date(String in, String out) {
        return null;
    }

    @Override
    public ArrayList<ReservationDTO> book(String rid) {

        try {
            String sql = "select check_In,check_Out from Reservation where RID='" + rid + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);

            ArrayList<ReservationDTO> reserveList = new ArrayList<>();
            while (rst.next()) {
                ReservationDTO c1 = new ReservationDTO(rst.getString("check_In"), rst.getString("check_Out"));
                reserveList.add(c1);
            }
            return reserveList;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ReservationDTO> fillForm(String Gid) {
        try {
            String sql = "select * from reservation r,guest g where g.GID=r.GID && g.GID='" + Gid + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            
            ArrayList<ReservationDTO> reserveList = new ArrayList<>();
            while (rst.next()) {
                try {
                    ReservationDTO c1 = new ReservationDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6), rst.getDouble(7));
                    reserveList.add(c1);
                } catch (SQLException ex) {
                    Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return reserveList;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
