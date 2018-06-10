/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.FoodDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.FoodDTO;
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
public class FoodDAOImpl implements FoodDAO {

    private Connection conn;

    public FoodDAOImpl() {
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
    public boolean add(FoodDTO c1) throws Exception {
        String SQL = "Insert into Food values(?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getFID());
        stm.setObject(2, c1.getFood_Name());
        stm.setObject(3, c1.getUnit_Price());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(FoodDTO c1) throws Exception {
        String SQL = "Update Food set Food_Name=?, Unit_Price=? where FID=?";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getFood_Name());
        stm.setObject(2, c1.getUnit_Price());
        stm.setObject(3, c1.getFID());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Food where FID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    @Override
    public ArrayList<FoodDTO> getAllID() throws Exception {
        String SQL = "Select * From Food";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FoodDTO> guestList = new ArrayList<>();
        while (rst.next()) {
            FoodDTO c1 = new FoodDTO(rst.getString(1), rst.getString(2), rst.getDouble(3));
            guestList.add(c1);
        }
        return guestList;
    }

    @Override
    public ArrayList<FoodDTO> getAllName() throws Exception {
        String SQL = "Select * From Food";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FoodDTO> foodList = new ArrayList<>();
        while (rst.next()) {
            FoodDTO c1 = new FoodDTO(rst.getString("FID"), rst.getString("Food_Name"), rst.getDouble("Unit_Price"));
            foodList.add(c1);
        }
        return foodList;

    }

    @Override
    public FoodDTO search(String id) throws Exception {
        String sql = "select * from Food where FID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            FoodDTO c1 = new FoodDTO(res.getString(1), res.getString(2), res.getDouble(3));
            return c1;
        } else {
            return null;
        }
    }

}
