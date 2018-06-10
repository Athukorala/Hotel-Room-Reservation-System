/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.Order_DetailDTO;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface Order_DetailController extends SuperController<Order_DetailDTO> {
    public ArrayList<Order_DetailDTO> searchResult1(String id);
    public boolean add(ArrayList<Order_DetailDTO> odList);
    public boolean update(ArrayList<Order_DetailDTO> odList);

    @Override
    public default Order_DetailDTO search(String id) throws Exception {
       return null;}
    
    
    
}
