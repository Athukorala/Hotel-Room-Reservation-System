/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.OrderDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface OrderContoller extends SuperController<OrderDTO> {
    public boolean transaction(OrderDTO dto);
    public boolean transactionUpdate(OrderDTO dto);
     public ArrayList<OrderDTO> searchToday(String date);
}
