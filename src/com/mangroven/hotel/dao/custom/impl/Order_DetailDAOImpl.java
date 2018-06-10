/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Order_DetailController;
import com.mangroven.hotel.dao.custom.Order_DetailDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.Order_DetailDTO;
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
public class Order_DetailDAOImpl implements Order_DetailDAO {

    //  private Order_DetailController odCntrl;
    private Connection conn;

    public Order_DetailDAOImpl() {

        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Order_DetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Order_DetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Order_DetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //odCntrl = (Order_DetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ORDER_DETAIL);
    }

    @Override
    public boolean add(Order_DetailDTO dto) throws Exception {
        String SQL = "Insert into OrderDetail Values(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOid());
        stm.setObject(2, dto.getPid());
        stm.setObject(3, dto.getQty());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Order_DetailDTO dto) throws Exception {
        String sql = "Insert into OrderDetail Values(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, dto.getOid());
        stm.setObject(2, dto.getPid());
        stm.setObject(3, dto.getQty());
        int res = stm.executeUpdate();
        System.out.println("" + res);
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "delete from OrderDetail where OID='" + id + "'";
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);

        return res > 0;
    }

    @Override
    public ArrayList<Order_DetailDTO> getAllID() throws Exception {
        String SQL = "Select * From OrderDetail";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Order_DetailDTO> odList = new ArrayList<>();
        while (rst.next()) {
            Order_DetailDTO c1 = new Order_DetailDTO(rst.getString(1), rst.getString(2), rst.getInt(3));
            odList.add(c1);
        }
        return odList;
    }

    @Override
    public ArrayList<Order_DetailDTO> getAllName() throws Exception {
        String SQL = "Select * From OrderDetail";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Order_DetailDTO> odList = new ArrayList<>();
        while (rst.next()) {
            Order_DetailDTO c1 = new Order_DetailDTO(rst.getString(1), rst.getString(2), rst.getInt(3));
            odList.add(c1);
        }
        return odList;
    }


    /*     String sql = "Select*from OrderDetail where OID='" + id + "'";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Order_DetailDTO c1 = new Order_DetailDTO(rst.getString(1), rst.getString(2), rst.getInt(3));
            return c1;
        } else {
            return null;
        }
    }*/
    @Override
    public ArrayList<Order_DetailDTO> searchResult(String id) {

        try {
            String sql = "Select * from OrderDetail where OID='" + id + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<Order_DetailDTO> odList = new ArrayList<>();
            while (rst.next()) {
                Order_DetailDTO c1 = new Order_DetailDTO(rst.getString("oid"), rst.getString("pid"), rst.getInt("qty"));
                // System.out.println("dddd");
                odList.add(c1);

            }
            return odList;
        } catch (SQLException ex) {
            Logger.getLogger(Order_DetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean add(ArrayList<Order_DetailDTO> odList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order_DetailDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
