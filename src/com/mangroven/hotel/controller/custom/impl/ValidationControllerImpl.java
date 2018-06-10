/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.controller.custom.ValidationController;
import com.mangroven.hotel.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author Athukorala
 */
public class ValidationControllerImpl implements ValidationController {

    @Override
    public boolean checkNic(String nic) throws Exception {

        if (nic.matches("\\d{9}[Vv]")) {

            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean checkPasspoert(String passport) throws Exception {
        if (passport.matches("[N]\\d{7}")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEmail(String email) throws Exception {
        if (email.matches("[A-Za-z0-9.]*.[^.]@[^.][A-Za-z0-9]*.[A-Za-z0-9].[A-Za-z0-9]*.[a-z]\\S")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkPrice(String price) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkName(String name) throws Exception {
        if (name.matches("\\w[A-Za-z]+\\S ")) {
            return true;
        } else {
            return true;

        }
    }

    @Override
    public boolean checkTel(String tel) throws Exception {

        if (tel.matches("[+]\\d{11}")||tel.matches("[+]\\d{12}")||tel.matches("[+]\\d{13}")||tel.matches("[+]\\d{14}")||tel.matches("[+]\\d{15}")||tel.matches("[+]\\d{16}")||tel.matches("[+]\\d{17}")||tel.matches("[+]\\d{18}")||tel.matches("[+]\\d{19}")||tel.matches("[+]\\d{20}")) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean qty(String qty) throws Exception {
        if (qty.matches("[-]\\d") || qty.matches("\\d")) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean add(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDTO> getAllName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
