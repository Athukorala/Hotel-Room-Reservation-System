/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Food_PackageController;
import com.mangroven.hotel.controller.custom.Food_Package_DetailController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.Food_PackageDAO;
import com.mangroven.hotel.dao.custom.Food_Package_DetailDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
import com.mangroven.hotel.dto.SuperDTO;
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
public class Food_PackageControllerImpl implements Food_PackageController {

    private Food_PackageDAO fp;
    private Connection conn;
    private Food_Package_DetailController fpdCntrl;
    // private Food_PackageController fpCntrl;
    // private Food_Package_DetailDAO fpd;

    public Food_PackageControllerImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        fp = (Food_PackageDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PACKAGE);
        //fpd = (Food_Package_DetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD_PACKAGE_DETAIL);
        // fpCntrl = (Food_PackageController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FOOD_PACKAGE);
        fpdCntrl = (Food_Package_DetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FOOD_PACKAGE_DETAIL);
    }

    @Override
    public boolean add(Food_PackageDTO c1) throws Exception {
        System.out.println("add");
        return fp.add(c1);
    }

    @Override
    public boolean update(Food_PackageDTO c1) throws Exception {
        return fp.update(c1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return fp.delete(id);
    }

    @Override
    public Food_PackageDTO search(String id) throws Exception {
        return fp.search(id);

    }

    @Override
    public ArrayList<Food_PackageDTO> getAllID() throws Exception {
        return fp.getAllID();
    }

    @Override
    public ArrayList<Food_PackageDTO> getAllName() throws Exception {
        return fp.getAllName();
    }

    @Override
    public boolean transaction(Food_PackageDTO dto) throws Exception {
        try {
            conn.setAutoCommit(false);
            boolean add = fp.add(dto);
            System.out.println("add " + add);
            if (add) {
                boolean addDetail = fpdCntrl.add(dto.getDetail());
                System.out.println("addDetail " + addDetail);
                if (addDetail) {
                    conn.commit();
                    return true;

                }
            }

            conn.rollback();

            return false;

        } finally {
            conn.setAutoCommit(true);
        }

    }

    @Override
    public boolean transactionPackageUpdate(Food_PackageDTO dto) {
        try {
            conn.setAutoCommit(false);
            boolean delete = fpdCntrl.delete(dto.getPID());
            if (delete) {
                boolean update = fp.update(dto);
                if (update) {
                    boolean updateDetail = fpdCntrl.add(dto.getDetail());
                    if (updateDetail) {
                        conn.commit();
                        return true;
                    }
                }
            }
            conn.rollback();
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(Food_PackageControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }
}
