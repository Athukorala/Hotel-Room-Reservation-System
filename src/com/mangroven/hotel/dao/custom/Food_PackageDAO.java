/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;

/**
 *
 * @author tharindu
 */
public interface Food_PackageDAO extends SuperDAO<Food_PackageDTO>{

    public boolean add(Food_PackageDTO dto);
    
}
