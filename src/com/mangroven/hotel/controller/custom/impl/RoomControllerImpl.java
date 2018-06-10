/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.dao.DAOFactory;
import com.mangroven.hotel.dao.custom.RoomDAO;
import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.controller.custom.RoomController;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.RoomDTO;
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
public class RoomControllerImpl implements RoomController{

    private RoomDAO room;

    public RoomControllerImpl() {
        room = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    }


    @Override
    public boolean add(RoomDTO c1) throws Exception {
        return room.add(c1);
    }

    @Override
    public boolean update(RoomDTO c1) throws Exception {
        return room.update(c1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return room.delete(id);
    }

    @Override
    public RoomDTO search(String id) throws Exception {
        return room.search(id);
    }

    @Override
    public ArrayList<RoomDTO> getAllID() throws Exception {
        return room.getAllID();
    }

    @Override
    public ArrayList<RoomDTO> getAllName() throws Exception {
        return room.getAllName();
    }
}
