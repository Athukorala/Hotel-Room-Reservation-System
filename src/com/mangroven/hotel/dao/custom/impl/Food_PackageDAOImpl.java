/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Food_PackageController;
import com.mangroven.hotel.controller.custom.Food_Package_DetailController;
import com.mangroven.hotel.controller.custom.impl.Food_PackageControllerImpl;
import com.mangroven.hotel.dao.custom.Food_PackageDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
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
public class Food_PackageDAOImpl implements Food_PackageDAO {
    private Food_PackageController fpCntrl;
    

    private Connection conn;

    public Food_PackageDAOImpl() {
       
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Food_PackageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Food_PackageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Food_PackageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fpCntrl=(Food_PackageController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FOOD_PACKAGE);
    }

    @Override
    public boolean add(Food_PackageDTO c1){
        try {
            //conn.setAutoCommit(false);
            String SQL = "Insert into Food_Package values(?,?,?)";
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, c1.getPID());
            stm.setObject(2, c1.getPackage_Name());
            stm.setObject(3, c1.getPackage_Price());
            
            
            
            int res = stm.executeUpdate();
            //System.out.println("Food_PackageDAOImpl "+res);
            if (res > 0) {
                return true;
                
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Food_PackageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Food_PackageDTO c1) throws Exception {
        String SQL = "Update Food_Package set Package_Name=?, Package_Price=? where PID=?";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getPackage_Name());
        stm.setObject(2, c1.getPackage_Price());
        stm.setObject(3, c1.getPID());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String SQL = "Delete From Food_Package where PID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    @Override
    public ArrayList<Food_PackageDTO> getAllID() throws Exception {
        String SQL="Select * From Food_Package";
		Statement stm=conn.createStatement();
		ResultSet rst=stm.executeQuery(SQL);
		ArrayList<Food_PackageDTO>packageList=new ArrayList<>();
		while(rst.next()){
			Food_PackageDTO c1=new Food_PackageDTO(rst.getString(1),rst.getString(2),rst.getDouble(3));
			packageList.add(c1);
                             
                        
		}
		return packageList;
    }

    @Override
    public ArrayList<Food_PackageDTO> getAllName() throws Exception {
         String SQL="Select * from Food_Package";
	Statement stm=conn.createStatement();
	ResultSet rst=stm.executeQuery(SQL);
	ArrayList<Food_PackageDTO>packageList=new ArrayList<>();
	while(rst.next()){
            Food_PackageDTO c1=new Food_PackageDTO(rst.getString("PID"),rst.getString("Package_Name"),rst.getDouble("Package_Price"));
		packageList.add(c1);
	}
	return packageList;}

    @Override
    public Food_PackageDTO search(String id) throws Exception {
        String sql = "select * from Food_Package where PID='" + id + "'  ";
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            Food_PackageDTO c1 = new Food_PackageDTO(res.getString(1), res.getString(2), res.getDouble(3));
            return c1;
        } else {
            return null;
        }
    }

   
}
