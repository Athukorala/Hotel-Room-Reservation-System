/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface IDControllerDAO extends SuperDAO<SuperDTO>{

    @Override
    public default boolean add(SuperDTO dto) throws Exception {
        return true;
    }

    @Override
    public default boolean delete(String id) throws Exception {
       return true; }

    @Override
    public default ArrayList<SuperDTO> getAllID() throws Exception {
       return null; }

    @Override
    public default ArrayList<SuperDTO> getAllName() throws Exception {
        return null;}

    @Override
    public default SuperDTO search(String id) throws Exception {
       return null;}

    @Override
    public default boolean update(SuperDTO dto) throws Exception {
       return true;}
    
    
}
