/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.GuestController;
import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.GuestDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public class GuestControllerImpl implements GuestController {

    private GuestDAO guest;

    public GuestControllerImpl() {
        guest = (GuestDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUEST);
    }

    @Override
    public boolean add(GuestDTO c1) throws Exception {
        return guest.add(c1);
    }

    @Override
    public boolean update(GuestDTO c1) throws Exception {
        return guest.update(c1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return guest.delete(id);
    }

    @Override
    public GuestDTO search(String id) throws Exception {
        return guest.search(id);
    }

    @Override
    public ArrayList<GuestDTO> getAllID() throws Exception {
        return guest.getAllID();
    }

    @Override
    public ArrayList<GuestDTO> getAllName() throws Exception {
        return guest.getAllName();
    }

    @Override
    public ArrayList<GuestDTO> getDetail(String name) {
        return guest.getDetail(name);
    }

}
