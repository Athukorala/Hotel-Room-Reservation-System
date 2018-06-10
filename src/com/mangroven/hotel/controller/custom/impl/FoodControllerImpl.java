    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.FoodController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.FoodDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.FoodDTO;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public class FoodControllerImpl implements FoodController {

    private FoodDAO food;

    public FoodControllerImpl() {

        food = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    }

    /* public static ArrayList<FoodDTO> getFoods(String pack) throws ClassNotFoundException, SQLException, IOException {
    String SQL = "Select Food_Name,f.FID From Food f,Package_Food_Detail p where (f.FID=p.FID) && p.PID=? ";
    Connection conn = ConnectionFactory.getInstance().getConnection();
    PreparedStatement stm = conn.prepareStatement(SQL);
    stm.setObject(1, pack);
    ResultSet rst = stm.executeQuery();
    ArrayList<FoodDTO> flist = new ArrayList<>();
    if (rst.next()) {
    FoodDTO f = new FoodDTO(rst.getString(1), rst.getString(2), rst.getDouble(3));
    flist.add(f);
    }
    return flist;
    }*/

    @Override
    public boolean add(FoodDTO c1) throws Exception {
        return food.add(c1);
    }

    @Override
    public boolean update(FoodDTO c1) throws Exception {
        return food.update(c1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return food.delete(id);
    }

    @Override
    public FoodDTO search(String id) throws Exception {
        return food.search(id);
    }

    @Override
    public ArrayList<FoodDTO> getAllID() throws Exception {
        return food.getAllID();
    }

    @Override
    public ArrayList<FoodDTO> getAllName() throws Exception {
        return food.getAllName();

    }
}
