/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.GuestDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
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
public class GuestDAOImpl implements GuestDAO {

    private Connection conn;

    public GuestDAOImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GuestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GuestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    
    public boolean add(GuestDTO c1) throws Exception {
        
          //System.out.println(c1.getGID()+" "+c1.getName()+" "+c1.getAddress()+" "+c1.getTel()+" "+c1.getEmail()+" "+c1.getCountry()+" "+c1.getGender()+" "+c1.getDOB());
        String SQL = "Insert into Guest values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
         stm.setObject(1, c1.getGID());
        stm.setObject(2, c1.getName());
        stm.setObject(3, c1.getAddress());
        stm.setObject(4, c1.getTel());
        stm.setObject(5, c1.getEmail());

        stm.setObject(6, c1.getCountry());
        stm.setObject(7, c1.getGender());
        stm.setObject(8, c1.getDOB());
        stm.setObject(9, c1.getNic());
        stm.setObject(10, c1.getPassport());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(GuestDTO c1) throws Exception {
        String SQL = "Update Guest set Name=?, Address=?, Tel=?, Email=?, Country=?, DOB=?,Gender=?,NIC=?,Passport_No=? where GID=?";

        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getName());
        stm.setObject(2, c1.getAddress());
        stm.setObject(3, c1.getTel());
        stm.setObject(4, c1.getEmail());
        stm.setObject(5, c1.getCountry());

        stm.setObject(6, c1.getDOB());
        stm.setObject(7, c1.getGender());
        stm.setObject(8, c1.getNic());
        stm.setObject(9, c1.getPassport());
        stm.setObject(10, c1.getGID());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Guest where GID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    @Override
    public ArrayList<GuestDTO> getAllID() throws Exception {
         String SQL="Select * From Guest";
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery(SQL);
		ArrayList<GuestDTO>guestList=new ArrayList<>();
		while(res.next()){
			GuestDTO c1 = new GuestDTO(res.getString("GID"), res.getString("Name"), res.getString("Address"), res.getString("Tel"), res.getString("Email"), res.getString("Country"), res.getString("Gender"), res.getString("DOB"), res.getString("nic"), res.getString("passport_no"));
			guestList.add(c1);
		}
		return guestList;}

    @Override
    public ArrayList<GuestDTO> getAllName() throws Exception {
        String SQL="Select * From Guest";
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery(SQL);
		ArrayList<GuestDTO>guestList=new ArrayList<>();
		while(res.next()){
			GuestDTO c1 = new GuestDTO(res.getString("GID"), res.getString("Name"), res.getString("Address"), res.getString("Tel"), res.getString("Email"), res.getString("Country"), res.getString("Gender"), res.getString("DOB"), res.getString("nic"), res.getString("passport_no"));
			guestList.add(c1);
		}
		return guestList;
    }

    @Override
    public GuestDTO search(String id) throws Exception {
        String sql = "select * from Guest where GID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            GuestDTO c1 = new GuestDTO(res.getString("GID"), res.getString("Name"), res.getString("Address"), res.getString("Tel"), res.getString("Email"), res.getString("Country"), res.getString("Gender"), res.getString("DOB"), res.getString("NIC"), res.getString("Passport_No"));
            return c1;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<GuestDTO> getDetail(String name) {
        //System.out.println(name);
        try {
            String sql="Select * from Guest where Name='"+name+"' || NIC='"+name+"' || Passport_No='"+name+"' || DOB='"+name+"' || Tel='"+name+"' || GID='"+name+"'";
            Statement stm=conn.createStatement();
            ArrayList<GuestDTO> list=new ArrayList<>();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                GuestDTO c1 = new GuestDTO(res.getString("GID"), res.getString("Name"), res.getString("Address"), res.getString("Tel"), res.getString("Email"), res.getString("Country"), res.getString("Gender"), res.getString("DOB"), res.getString("nic"), res.getString("passport_no"));
                list.add(c1);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
