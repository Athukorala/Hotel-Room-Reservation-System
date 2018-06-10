/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.PasswordController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.PasswordDAO;
import com.mangroven.hotel.dto.PasswordDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public class PasswordControllerImpl implements PasswordController {

    private PasswordDAO pass;

    public PasswordControllerImpl() {
        pass = (PasswordDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PASSWORD);
    }

    @Override
    public boolean add(PasswordDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PasswordDTO dto) throws Exception {
        return pass.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return pass.delete(id);
    }

   
  

    @Override
    public PasswordDTO search(String id) throws Exception {
        return pass.search(id);
    }

    @Override
    public PasswordDTO getAllDetail() throws Exception {
        return pass.getAllDetail();}

}
