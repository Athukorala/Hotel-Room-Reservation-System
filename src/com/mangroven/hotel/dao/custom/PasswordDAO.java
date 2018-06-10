/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.PasswordDTO;

/**
 *
 * @author tharindu
 */
public interface PasswordDAO extends SuperDAO<PasswordDTO>{
    public PasswordDTO getAllDetail()throws Exception;
}
