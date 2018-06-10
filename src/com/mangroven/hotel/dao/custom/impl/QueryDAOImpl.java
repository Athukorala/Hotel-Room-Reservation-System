/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.custom.impl;

import com.mangroven.hotel.dao.custom.PaymentDAO;
import com.mangroven.hotel.dao.custom.QueryDAO;
import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.dto.FoodDTO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import com.mangroven.hotel.dto.PaymentDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import com.mangroven.hotel.dto.SuperDTO;
import java.io.IOException;
import java.sql.Connection;
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
public class QueryDAOImpl implements QueryDAO {

    private Connection conn;

    public QueryDAOImpl() {
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*    @Override
    public double gidPayment(String id) {)
     */
    @Override
    public ArrayList<ReservationDTO> getRserveRoom(String in, String out) {
        
        try {
            String sql ="select RID from Room where RID not in( select RID from Reservation where(Check_In<='"+in+"' && Check_Out>='"+in+"') || (Check_In <='"+out+"' && Check_Out>='"+out+"') || (Check_In>= '"+in+"' && Check_Out<= '"+out+"') || ( Check_Out='"+in+"' && Check_Out='"+out+"') || (Check_In='"+out+"' && Check_In='"+out+"'))";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            ArrayList<ReservationDTO> reserveList = new ArrayList<>();
            while (res.next()) {
                ReservationDTO c1 = new ReservationDTO(res.getString("rID"));

                reserveList.add(c1);
            }
            return reserveList;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> gidPayment(String id) {
        try {
            String sql = "select sum(Amount) as full,sum(Advance) as advance,sum(Amount)-sum(Advance) from Reservation r,Payment p,Guest g where g.GID=r.GID && r.RsID=p.RsID && g.GID='" + id + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<PaymentDTO> payList = new ArrayList<>();
            while (rst.next()) {
                PaymentDTO p1 = new PaymentDTO(rst.getDouble(1), rst.getDouble(2), rst.getDouble(3));
                payList.add(p1);

            }
            return payList;
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<Order_DetailDTO> getOrderDetail(String oid) {
        try {
            String sql = "select p.PID,Package_Name,Qty,(Package_Price*Qty) as price from Food_Package p,OrderDetail od,Orders o where o.OID=od.OID && p.PID=od.PID && o.OID='" + oid + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<Order_DetailDTO> odList = new ArrayList<>();
            while (rst.next()) {
                Order_DetailDTO od = new Order_DetailDTO(rst.getString("pid"), rst.getString("package_name"), rst.getInt("qty"), rst.getDouble("price"));
                odList.add(od);
                //return odList;

            }
            return odList;
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<FoodDTO> getPackageDetail(String pid) {
        try {
            String sql="select f.FID,f.Food_Name from Food_Package p,Food f,Package_Food_Detail fd where f.FID=fd.FID && fd.PID=p.PID && p.PID='"+pid+"'";
            Statement stm = conn.createStatement();      
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<FoodDTO> foodList=new ArrayList<>();
            while(rst.next()){
                FoodDTO f1=new FoodDTO(rst.getString("FID"), rst.getString("Food_Name"));
                foodList.add(f1);
            }
            return foodList;
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> searchAllPayment(String id) {
        try {
            String sql="select PYID,p.RsID,p.RID,p.OID,Date,Time,Amount,Advance from Payment p,Reservation r where p.RsID=r.RsID && r.RsID='"+id+"'";
            Statement stm=conn.createStatement();
            ResultSet rst=stm.executeQuery(sql);
            ArrayList<PaymentDTO> list=new ArrayList<>();
            while(rst.next()){
                PaymentDTO p1=new PaymentDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getDouble(7),rst.getDouble(8));
                list.add(p1);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    @Override
    public ArrayList<ReservationDTO> getTodayList(String in, String out) {
     try {
            String sql ="select RID from Room where RID in( select RID from Reservation where(Check_In<='"+in+"' && Check_Out>='"+in+"') || (Check_In <='"+out+"' && Check_Out>='"+out+"') || (Check_In>= '"+in+"' && Check_Out<= '"+out+"') || ( Check_Out='"+in+"' && Check_Out='"+out+"') || (Check_In='"+out+"' && Check_In='"+out+"'))";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            ArrayList<ReservationDTO> reserveList = new ArrayList<>();
            while (res.next()) {
                ReservationDTO c1 = new ReservationDTO(res.getString("rID"));

                reserveList.add(c1);
            }
            return reserveList;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    }
    
    
   

