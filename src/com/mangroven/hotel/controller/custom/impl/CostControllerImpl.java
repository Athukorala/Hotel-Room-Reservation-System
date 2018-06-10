/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.CostController;
import com.mangroven.hotel.controller.custom.PaymentController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.CostDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.CostDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Athukorala
 */
public class CostControllerImpl implements CostController {

    private Connection conn;
    private CostDAO cost;
    private PaymentController pay;

    public CostControllerImpl() {
        cost = (CostDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COST);
        pay = (PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(CostDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CostDTO dto) throws Exception {
        return cost.update(dto);}

    @Override
    public boolean delete(String id) throws Exception {
        return cost.delete(id);}

    @Override
    public ArrayList<CostDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CostDTO> getAllName() throws Exception {
       return cost.getAllName(); }

    @Override
    public CostDTO search(String id) throws Exception {
        return cost.search(id);}

    @Override
    public boolean transactionCost(CostDTO dto) {

        try {
            conn.setAutoCommit(false);
            boolean add = cost.add(dto);

            if (add) {

                boolean add1 = pay.added(dto.getPayid(), dto.getCostID(), dto.getCost(), dto.getDate(), dto.getTime());

                if (add1) {

                    conn.commit();

                    return true;

                }
            }

            conn.rollback();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CostControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CostControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        return false;
    }
}
