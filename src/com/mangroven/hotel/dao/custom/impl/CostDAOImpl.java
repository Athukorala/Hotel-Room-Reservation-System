/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.CostDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.CostDTO;
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
 * @author Athukorala
 */
public class CostDAOImpl implements CostDAO{
private Connection conn;

    public CostDAOImpl() {
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
    public boolean add(CostDTO c1) throws Exception {
        String SQL = "Insert into Cost values(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getCostID());
        stm.setObject(2, c1.getDescription());
        stm.setObject(3, c1.getCost());
        stm.setObject(4, c1.getDate());
        stm.setObject(5, c1.getTime());
        

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(CostDTO c1) throws Exception {
        String sql="Update Cost set Description=?, Cost=?, Date=?,Time=? where CostID=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, c1.getDescription());
        stm.setObject(2, c1.getCost());
        stm.setObject(3, c1.getDate());
        stm.setObject(4, c1.getTime());
        stm.setObject(5, c1.getCostID());
        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Cost where CostID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;}

    @Override
    public ArrayList<CostDTO> getAllID() throws Exception {
          String SQL = "Select * From Cost";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CostDTO> guestList = new ArrayList<>();
        while (rst.next()) {
            CostDTO c1;
              c1 = new CostDTO(rst.getString(1), rst.getString(2), rst.getDouble(3),rst.getString(4),rst.getString(5));
            guestList.add(c1);
        }
        return guestList;
    }

    @Override
    public ArrayList<CostDTO> getAllName() throws Exception {
       String SQL = "Select * From Cost";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CostDTO> list = new ArrayList<>();
        while (rst.next()) {
             CostDTO c1;
            c1 = new CostDTO(rst.getString(1), rst.getString(2), rst.getDouble(3),rst.getString(4),rst.getString(5));
            list.add(c1);
        }
        return list;

    }


    @Override
    public CostDTO search(String id) throws Exception {
       String sql = "select * from Cost where CostID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            CostDTO c1 = new CostDTO(rst.getString(1), rst.getString(2), rst.getDouble(3),rst.getString(4),rst.getString(5));
            return c1;
        } else {
            return null;
        }
    }
    
}
