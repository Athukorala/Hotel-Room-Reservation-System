/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.PasswordDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.PasswordDTO;
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
public class PasswordDAOImpl implements PasswordDAO{
     private Connection conn;

    public PasswordDAOImpl() {
         try {
             conn = ConnectionFactory.getInstance().getConnection();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(PasswordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(PasswordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(PasswordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }


    @Override
    public boolean add(PasswordDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PasswordDTO c1) throws Exception {
         String SQL = "Update Password set Password=?, User_Name=? where passID=?";
        PreparedStatement stm = conn.prepareStatement(SQL);
       //System.out.println(c1.getPassword()+" "+c1.getUserName()+" "+c1.getId());
        stm.setObject(1, c1.getPassword());
        stm.setObject(2, c1.getUserName());
        stm.setObject(3, c1.getId());
        

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PasswordDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PasswordDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PasswordDTO search(String id) throws Exception {
       
        String sql = "select * from Password where passID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            PasswordDTO c1 = new PasswordDTO(res.getString(1), res.getString(2),res.getString(3));
            return c1;
        } else {
            return null;
        }
    }

    @Override
    public PasswordDTO getAllDetail() throws Exception {
        String SQL="Select * From Password";
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery(SQL);
		
		while(res.next()){
			PasswordDTO c1=new PasswordDTO(res.getString(1),res.getString(2),res.getString(3));
			return c1;
		}
         return null;
		
    }
    
}
