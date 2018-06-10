/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom;

import com.mangroven.hotel.controller.SuperController;
import com.mangroven.hotel.dto.FoodDTO;
import com.mangroven.hotel.dto.Food_PackageDTO;
import com.mangroven.hotel.dto.Food_Package_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author tharindu
 */
public interface Food_PackageController extends SuperController<Food_PackageDTO>{

   
    public boolean transaction(Food_PackageDTO dto)throws Exception;
    public boolean transactionPackageUpdate(Food_PackageDTO dto);

   // public boolean add(Food_Package_DetailDTO dto);
}
