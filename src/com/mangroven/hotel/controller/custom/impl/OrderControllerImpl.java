/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.OrderContoller;
import com.mangroven.hotel.controller.custom.Order_DetailController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.OrdersDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.OrderDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class OrderControllerImpl implements OrderContoller {

    private Connection conn;

    private OrdersDAO order;
    private Order_DetailController odCntrl;

    public OrderControllerImpl() {
        odCntrl = (Order_DetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ORDER_DETAIL);
        order = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
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
    public boolean add(OrderDTO dto) throws Exception {
        return order.add(dto);
    }

    @Override
    public boolean update(OrderDTO dto) throws Exception {
        return order.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return order.delete(id);
    }

    @Override
    public ArrayList<OrderDTO> getAllID() throws Exception {
        return order.getAllID();
    }

    @Override
    public ArrayList<OrderDTO> getAllName() throws Exception {
        return order.getAllName();
    }

    @Override
    public OrderDTO search(String id) throws Exception {
        return order.search(id);
    }

    @Override
    public boolean transaction(OrderDTO dto) {

        try {
            conn.setAutoCommit(false);
            boolean add = order.add(dto);
            if (add) {
                boolean addDetail = odCntrl.add(dto.getOdList());
                if (addDetail) {
                    
                    
                    // ----- Look Payment ControllerImpl
                    //conn.commit();
                    return true;
                }
            }
            conn.rollback();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          // ------- look Payment ControllerImpl ---------------------------

        /*finally{
         /* try {
         conn.setAutoCommit(true);
         } catch (SQLException ex) {
         Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         }*/
        return false;

    }

    @Override
    public ArrayList<OrderDTO> searchToday(String date) {
        return order.searchToday(date);
    }

    @Override
    public boolean transactionUpdate(OrderDTO dto) {
        try {
            conn.setAutoCommit(false);
            boolean delete = odCntrl.delete(dto.getOid());

            if (delete) {

                boolean update = order.update(dto);
                if (update) {
                    boolean updateList = odCntrl.add(dto.getOdList());

                    if (updateList) {

                        //---- Look Payment ControllerImpl
                        //conn.commit();
                        return true;
                    }
                }
            }
            conn.rollback();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // ------- look Payment ControllerImpl ---------------------------
        /*finally {
         try {
         conn.setAutoCommit(true);
        
        
         } catch (SQLException ex) {
         Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         }*/
        return false;
    }

}
