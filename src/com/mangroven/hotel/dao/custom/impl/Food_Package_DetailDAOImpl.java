/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.Food_Package_DetailDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class Food_Package_DetailDAOImpl implements Food_Package_DetailDAO {

    private Connection conn;
    private Food_Package_DetailDAO fpd;

    public Food_Package_DetailDAOImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        // fpd = (Food_Package_DetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PACKAGE_DETAIL);
    }

    @Override
    public boolean add(Food_Package_DetailDTO pfd) throws Exception {
        String SQL = "Insert into Package_Food_Detail values(?,?)";
        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, pfd.getPID());
        stm.setObject(2, pfd.getFID());
        int res = stm.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean update(Food_Package_DetailDTO pfd) throws Exception {
        String SQL = "Insert into Package_Food_Detail values(?,?)";
        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, pfd.getPID());
        stm.setObject(2, pfd.getFID());
        int res = stm.executeUpdate();

        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       String SQL="Delete from Package_Food_Detail where PID='"+id+"'";
        Statement stm = conn.createStatement();
        //System.out.println(SQL);
        int res = stm.executeUpdate(SQL);
        //System.out.println("guest "+res);
        return res > 0;
    
    }

    @Override
    public ArrayList<Food_Package_DetailDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Food_Package_DetailDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Food_Package_DetailDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<Food_Package_DetailDTO> packageDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
