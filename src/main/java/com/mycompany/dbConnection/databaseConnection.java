/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jawad Saleem
 */
public class databaseConnection {   
    static Connection conn; 
    static String driver = "com.microdoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=quiz_management_db;encrypt=true;trustServerCertificate=true";
    static String userName = "jawad";
    static String pass = "jawad";
    public static Connection getConnection() throws SQLException{
        if(conn == null){
             //registering driver
        try{
        Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
        //establishing connection through driver
        conn = DriverManager.getConnection(url,userName,pass);
        }
       
        return conn;
    }
    
    //code to test connection
    
//    public static void main(String []args){
//        try{
//        databaseConnection con = new databaseConnection();
//        System.out.println("Connection made");
//        }
//        catch(Exception e){
//            System.out.println("Connection not made");
//        }
//        
//        
//    }
}
