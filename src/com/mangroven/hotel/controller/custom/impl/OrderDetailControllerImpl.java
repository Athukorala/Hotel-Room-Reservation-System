/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Order_DetailController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.Order_DetailDAO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class OrderDetailControllerImpl implements Order_DetailController {

    private Order_DetailDAO od;


    public OrderDetailControllerImpl() {
        od = (Order_DetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
        
    }

    @Override
    public boolean add(Order_DetailDTO dto) throws Exception {
        return od.add(dto);
    }

    @Override
    public boolean update(Order_DetailDTO dto) throws Exception {
        return od.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return od.delete(id);
    }

    @Override
    public ArrayList<Order_DetailDTO> getAllID() throws Exception {
        return od.getAllID();
    }

    @Override
    public ArrayList<Order_DetailDTO> getAllName() throws Exception {
        return od.getAllName();
    }

    @Override
    public Order_DetailDTO search(String id) throws Exception {
        return od.search(id);

    }

    @Override
    public ArrayList<Order_DetailDTO> searchResult1(String id) {
        return od.searchResult(id);
    }

    @Override
    public boolean add(ArrayList<Order_DetailDTO> odList) {
        for (Order_DetailDTO ob : odList) {

            try {
                boolean isAdd = od.add(ob);
                //System.out.println("OrderDetailControllerImpl "+isAdd);
                if (!isAdd) {
                    return false;
                }
            } catch (Exception ex) {
                Logger.getLogger(OrderDetailControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean update(ArrayList<Order_DetailDTO> odList) {
        for (Order_DetailDTO order_DetailDTO : odList) {
            try {
                boolean isUpdate=od.update(order_DetailDTO);
                if(!isUpdate){
                    return false;
                }
            } catch (Exception ex) {
                Logger.getLogger(OrderDetailControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
            
        }
    

}
