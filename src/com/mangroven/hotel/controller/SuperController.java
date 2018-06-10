/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller;

import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */

    public interface SuperController<T extends SuperDTO> {
    
    public boolean add(T dto) throws Exception;
    
    public boolean update(T dto) throws Exception;
    
    public boolean delete(String id) throws Exception;
    
    public ArrayList<T> getAllID() throws Exception;
    
    public ArrayList<T> getAllName() throws Exception;
    
    public T search(String id) throws Exception;   
    
    
    
}

