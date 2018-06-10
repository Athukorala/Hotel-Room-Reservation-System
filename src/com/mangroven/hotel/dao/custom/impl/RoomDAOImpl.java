/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.RoomDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.RoomDTO;
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
public class RoomDAOImpl implements RoomDAO {

    private Connection conn;

    public RoomDAOImpl() {
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
    public boolean add(RoomDTO c1) throws Exception {
        String SQL = "Insert into Room values(?,?,?,?)";

        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getRID());
        stm.setObject(2, c1.getRoom_Name());
        stm.setObject(3, c1.getRoom_Description());
        stm.setObject(4, c1.getRoom_Price());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(RoomDTO c1) throws Exception {
        String SQL = "Update Room set Room_Name=?, Room_Price=?, Room_Description=? where RID=?";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getRoom_Name());
        stm.setObject(2, c1.getRoom_Price());
        stm.setObject(3, c1.getRoom_Description());
        stm.setObject(4, c1.getRID());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Room where id='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    @Override
    public ArrayList<RoomDTO> getAllID() throws Exception {
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Room");
        ArrayList<RoomDTO> roomID = new ArrayList<>();
        while (rst.next()) {
            RoomDTO dto=new RoomDTO(rst.getString("RID"));
            roomID.add(dto);
        }
        return roomID;
    }

    @Override
    public ArrayList<RoomDTO> getAllName() throws Exception {
        String SQL="Select * From Room";
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery(SQL);
		ArrayList<RoomDTO>roomList=new ArrayList<>();
		while(res.next()){
			RoomDTO c1=new RoomDTO(res.getString("RID"),res.getString("Room_Name"),res.getString("Room_Description"),res.getDouble("Room_Price"));
			roomList.add(c1);
		}
		return roomList;
    }

    @Override
    public RoomDTO search(String id) throws Exception {
        //System.out.println(" dkfdkf"+id);
       String sql="select * from Room where RID='"+id+"'  ";
		Statement stm=conn.createStatement();
		ResultSet res=stm.executeQuery(sql);
		if(res.next()){
			RoomDTO c1=new RoomDTO(res.getString("RID"),res.getString("Room_Name"),res.getString("Room_Description"),res.getDouble("Room_Price"));
		return c1;
		}else{
		return null;
	}
    }
}
