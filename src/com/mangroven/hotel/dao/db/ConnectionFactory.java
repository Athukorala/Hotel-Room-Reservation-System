/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao.db;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tharindu
 */
public class ConnectionFactory {

    public static Object getDBConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private Connection conn;
	private static ConnectionFactory dbConnection;
	private ConnectionFactory()throws ClassNotFoundException,SQLException, IOException{
            FileReader dbFileReader=null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
             
             
             Properties dpProperties=new Properties();
             File dbFile=new File("Setting/dbSetting.properties");
             dbFileReader = new FileReader(dbFile);
             dpProperties.load(dbFileReader);
            
             
             conn=(Connection) DriverManager.getConnection("jdbc:mysql://"+dpProperties.getProperty("ip")+"/"+dpProperties.getProperty("database"),(String)dpProperties.getProperty("userName"),(String)dpProperties.getProperty("password"));
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             try {
                 dbFileReader.close();
             } catch (IOException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
	}
	public Connection getConnection(){
		return conn;
	}
	public static ConnectionFactory getInstance()throws ClassNotFoundException,SQLException, IOException{
		if(dbConnection==null){
			dbConnection=new ConnectionFactory();
		}
		return dbConnection;
	}
}
