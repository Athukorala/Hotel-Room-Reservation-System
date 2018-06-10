/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author Athukorala
 */
public interface ValidationController extends SuperController<SuperDTO>{
    
    public boolean checkNic(String nic) throws Exception;
    public boolean checkPasspoert(String passport) throws Exception;
    public boolean checkEmail(String email) throws Exception;
    public boolean checkPrice(String price) throws Exception;
    public boolean checkName(String name)throws Exception;
    public boolean checkTel(String tel) throws Exception;
    public boolean qty(String qty) throws Exception;
    @Override
    public default boolean add(SuperDTO dto) throws Exception {
        return(true);}

    @Override
    public default boolean delete(String id) throws Exception {
       return(true);}



    @Override
    public default ArrayList<SuperDTO> getAllID() throws Exception {
       return(null);}

    @Override
    public default ArrayList<SuperDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public default SuperDTO search(String id) throws Exception {
        return(null);}



    @Override
    public default boolean update(SuperDTO dto) throws Exception {
       return(true);}
    
    
    
}
