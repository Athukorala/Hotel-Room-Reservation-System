/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface Order_DetailDAO extends SuperDAO<Order_DetailDTO>{
    public ArrayList<Order_DetailDTO> searchResult(String id);
    public boolean add(ArrayList<Order_DetailDTO> odList);
}
