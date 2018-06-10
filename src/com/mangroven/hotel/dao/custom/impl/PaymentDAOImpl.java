/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.PaymentDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.PaymentDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class PaymentDAOImpl implements PaymentDAO {

    private Connection conn;

    public PaymentDAOImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(PaymentDTO c1) throws Exception {
        String SQL = "Insert into Payment values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, c1.getPyid());
        stm.setObject(2, c1.getRsid());
        stm.setObject(3, c1.getRid());
        stm.setObject(4, c1.getOid());
        stm.setObject(5, null);
        stm.setObject(6, c1.getDate());
        stm.setObject(7, c1.getTime());
        stm.setObject(8, null);
        stm.setObject(9, c1.getAmount());
        stm.setObject(10, c1.getAdvance());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(PaymentDTO c1) throws Exception {
        String SQL = "Update Payment set Date=?, Time=?, Amount=? , RsID=? , OID=?, RID=? ,Advance=?, CostID=?, Cost=? where PYID=?";
        //System.out.println(c1.getPyid() + " " + c1.getRsid() + " " + c1.getRid() + " " + c1.getOid() + " " + c1.getDate() + " " + c1.getTime() + " " + c1.getAdvance() + " " + c1.getAmount() + " " + c1.getNewAmount());
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, c1.getDate());
        stm.setObject(2, c1.getTime());
        stm.setObject(3, c1.getAmount());
        stm.setObject(4, c1.getRsid());
        stm.setObject(5, c1.getOid());
        stm.setObject(6, c1.getRid());
        stm.setObject(7, c1.getAdvance());
        stm.setObject(8, null);
        stm.setObject(9, null);

        stm.setObject(10, c1.getPyid());

        int res = stm.executeUpdate();
        //System.out.println(" " + res);
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        //System.out.println("id "+id);
        String SQL = "Delete From Payment where PYID='" + id + "'";
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);

        return res > 0;
    }

    @Override
    public ArrayList<PaymentDTO> getAllID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaymentDTO> getAllName() throws Exception {
        String SQL = "Select * From Payment";
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<PaymentDTO> paymentList = new ArrayList<>();
        while (rst.next()) {
            PaymentDTO c1 = new PaymentDTO(rst.getString("pyid"), rst.getString("rsid"), rst.getString("rid"), rst.getString("oid"), rst.getString("date"), rst.getString("time"), rst.getDouble("amount"), rst.getDouble("advance"));
            paymentList.add(c1);
        }
        return paymentList;
    }

    @Override
    public PaymentDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaymentDTO> rsidPayment(String id) {
        try {
            String sql = "select sum(Amount),sum(Advance),sum(Amount)-sum(Advance) from Payment where RsID='" + id + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<PaymentDTO> payList = new ArrayList<>();
            while (rst.next()) {
                PaymentDTO p1 = new PaymentDTO(rst.getDouble(1), rst.getDouble(2), rst.getDouble(3));
                payList.add(p1);
                return payList;
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public PaymentDTO searchId(String rsid, String rid) {
        try {
            String sql = "Select*from Payment where RsID='" + rsid + "' and RID='" + rid + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            // ArrayList<PaymentDTO> payList=new ArrayList<>();
            while (rst.next()) {
                PaymentDTO c1 = new PaymentDTO(rst.getString("pyid"), rst.getString("rsid"), rst.getString("rid"), rst.getString("oid"), rst.getString("date"), rst.getString("time"), rst.getDouble("amount"), rst.getDouble("advance"));
                // System.out.println("ddddddd");
                return c1;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PaymentDTO searchId(String oid) {
        try {
            String sql = "Select*from Payment where OID='" + oid + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            // ArrayList<PaymentDTO> payList=new ArrayList<>();
            while (rst.next()) {
                PaymentDTO c1 = new PaymentDTO(rst.getString("pyid"), rst.getString("rsid"), rst.getString("rid"), rst.getString("oid"), rst.getString("date"), rst.getString("time"), rst.getDouble("amount"), rst.getDouble("advance"));
                ;
                return c1;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteRoom(String rsid, String rid) {
        try {
            String SQL = "Delete From Payment where RID='" + rid + "' and RSID='" + rsid + "'";
            Statement stm = conn.createStatement();
            int res = stm.executeUpdate(SQL);
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteOrder(String oid) {
        try {
            String SQL = "Delete From Payment where OID='" + oid + "'";
            Statement stm = conn.createStatement();
            int res = stm.executeUpdate(SQL);
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean added(String pyid, String costId, double cost, String date, String time) {
        try {
            String SQL = "Insert into Payment values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, pyid);
            stm.setObject(2, null);
            stm.setObject(3, null);
            stm.setObject(4, null);
            stm.setObject(5, costId);
            stm.setObject(6, date);
            stm.setObject(7, time);
            stm.setObject(8, cost);
            stm.setObject(9, null);
            stm.setObject(10, null);

            int res = stm.executeUpdate();
            return res > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<PaymentDTO> getAllNameS() {
        try {
            String SQL = "Select * From Payment";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            ArrayList<PaymentDTO> paymentList = new ArrayList<>();
            while (rst.next()) {
                PaymentDTO c1 = new PaymentDTO(rst.getString("pyid"), rst.getString("rsid"), rst.getString("rid"), rst.getString("oid"), rst.getString("CostID"), rst.getString("date"), rst.getString("time"), rst.getDouble("Cost"), rst.getDouble("amount"), rst.getDouble("advance"));
                paymentList.add(c1);
            }
            return paymentList;
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PaymentDTO getProfit() {
        
        try {
            String sql="select sum(Advance),sum(Cost), sum(Advance)-sum(Cost) from Payment";
            Statement stm=conn.createStatement();
            ResultSet rst=stm.executeQuery(sql);
            //PaymentDTO dto=new PaymentDTO();
            if(rst.next()){
                PaymentDTO dto=new PaymentDTO(rst.getDouble(1),rst.getDouble(2),rst.getDouble(3));
                return dto;
            }   } catch (SQLException ex) {
            Logger.getLogger(PaymentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
