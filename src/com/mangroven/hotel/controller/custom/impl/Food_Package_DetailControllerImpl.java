/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.Food_PackageController;
import com.mangroven.hotel.controller.custom.Food_Package_DetailController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.Food_Package_DetailDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class Food_Package_DetailControllerImpl implements Food_Package_DetailController{
    
   private Food_Package_DetailDAO fpd;

    public Food_Package_DetailControllerImpl() {
        fpd=(Food_Package_DetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PACKAGE_DETAIL);
    }
   
    @Override
    public boolean add(Food_Package_DetailDTO dto) throws Exception {
        return fpd.add(dto);
    }

    @Override
    public boolean update(Food_Package_DetailDTO dto) throws Exception {
               return fpd.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
                return fpd.delete(id);
    }

    @Override
    public Food_Package_DetailDTO search(String id) throws Exception {
        return fpd.search(id);
    }

    @Override
    public ArrayList<Food_Package_DetailDTO> getAllID() throws Exception {
        return fpd.getAllID();
    }

    @Override
    public ArrayList<Food_Package_DetailDTO> getAllName() throws Exception {
        return fpd.getAllName();
    }

    @Override
    public boolean add(ArrayList<Food_Package_DetailDTO> odList) {
        for (Food_Package_DetailDTO package_Food_Detail : odList) {
            try {
                boolean isAddList=fpd.add(package_Food_Detail);
                System.out.println("food package detail conto impl success yes/no "+isAddList);
                if(!isAddList){
                    return false;
                }
            } catch (Exception ex) {
                Logger.getLogger(Food_Package_DetailControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

   /* @Override
    public boolean add(ArrayList<Food_Package_DetailDTO> odList) {
       for (Food_Package_DetailDTO package_Food_Detail : odList) {
            try {
                boolean isAddList=fpd.add(package_Food_Detail);
                if(!isAddList){
                    return false;
                }
            } catch (Exception ex) {
                Logger.getLogger(Food_Package_DetailControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    } */
    }
