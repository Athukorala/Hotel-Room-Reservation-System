/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller.custom.impl;

import com.mangroven.hotel.dao.db.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tharindu
 */
public class IDControllerImpl{
     public static String getLastID(String tableName, String colName) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select " + colName + " from " + tableName + " order by 1 desc limit 1";
        Connection conn = ConnectionFactory.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
