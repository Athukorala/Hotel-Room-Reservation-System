/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Order_DetailController;
import com.mangroven.hotel.dao.custom.OrdersDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.OrderDTO;
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
public class OrdersDAOImpl implements OrdersDAO {

    private Order_DetailController odCntrl;
    private Connection conn;

    public OrdersDAOImpl() {
        odCntrl = (Order_DetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ORDER_DETAIL);
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
    public boolean add(OrderDTO dto) throws Exception {
        String sql = "Insert into Orders values(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, dto.getOid());
        stm.setObject(2, dto.getRsid());
        stm.setObject(3, dto.getDate());
        stm.setObject(4, dto.getPeriod());
        stm.setObject(5, dto.getPrice());

        int res = stm.executeUpdate();
        return res > 0;

    }

    @Override
    public boolean update(OrderDTO dto) throws Exception {
        String sql="Update Orders set RsID=?,Date=?,Period=?,Price=? where OID=?";
          PreparedStatement stm = conn.prepareStatement(sql);
          stm.setObject(1, dto.getRsid());
          stm.setObject(2, dto.getDate());
          stm.setObject(3, dto.getPeriod());
          stm.setObject(4, dto.getPrice());
          stm.setObject(5, dto.getOid());
           int res = stm.executeUpdate();
        return res > 0;
    
    }

    @Override
    public boolean delete(String oid) throws Exception {

        String SQL = "Delete From Orders where OID='" + oid + "'";

        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(SQL);

        return res > 0;
    }

    @Override
    public ArrayList<OrderDTO> getAllID() throws Exception {
        String SQL = "Select * From Orders";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<OrderDTO> odList = new ArrayList<>();
        while (rst.next()) {
            OrderDTO c1 = new OrderDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
            odList.add(c1);
        }
        return odList;
    }

    @Override
    public ArrayList<OrderDTO> getAllName() throws Exception {
        String SQL = "Select * From Orders";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<OrderDTO> odList = new ArrayList<>();
        while (rst.next()) {
            OrderDTO c1 = new OrderDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
            odList.add(c1);
        }
        return odList;
    }

    @Override
    public OrderDTO search(String id) throws Exception {
        String sql = "select * from Orders where OID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            OrderDTO c1 = new OrderDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
            return c1;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<OrderDTO> searchToday(String date) {
        
        try {
            String sql = "Select * from Orders where Date='" + date + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<OrderDTO> odList = new ArrayList<>();
            //System.out.println(rst);
            while (rst.next()) {
                OrderDTO c1 = new OrderDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
                // System.out.println(rst.getString(1));
                odList.add(c1);

            }
            return odList;
        } catch (SQLException ex) {
            Logger.getLogger(Order_DetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
