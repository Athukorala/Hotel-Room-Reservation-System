/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.PasswordDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface PasswordController extends SuperController<PasswordDTO> {

    @Override
    public default ArrayList<PasswordDTO> getAllID() throws Exception {
       return null;}

    @Override
    public default ArrayList<PasswordDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public PasswordDTO getAllDetail()throws Exception;
    
}
