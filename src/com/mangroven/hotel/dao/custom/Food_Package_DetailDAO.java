/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom;

import com.mangroven.hotel.dao.SuperDAO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface Food_Package_DetailDAO extends SuperDAO<Food_Package_DetailDTO>{
    public boolean add(ArrayList<Food_Package_DetailDTO> packageDetail);
}
