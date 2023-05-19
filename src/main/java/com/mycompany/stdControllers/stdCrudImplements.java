/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stdControllers;

import com.mycompany.stdModals.Student;
import com.mycompany.dbConnection.databaseConnection;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jawad Saleem
 */
public class stdCrudImplements implements stdCrudInterface{
    @Override
    public void stdInsert(Student std){
        Boolean alreadyRegtd = false;
        try{
            Connection conn = databaseConnection.getConnection();
            String query = "SELECT stdName ,stdEmail FROM stdntTbl WHERE stdName=? AND stdEmail=?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1,std.getStdName());
            ps.setString(2,std.getStdEmail());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alreadyRegtd = true;
            }
            if(alreadyRegtd == false){
                String query1 = "INSERT INTO stdntTbl (stdName,stdEmail,stdPhone) VALUES (?,?,?)";
                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1,std.getStdName());
                ps1.setString(2,std.getStdEmail());
                ps1.setString(3,std.getStdPhone());
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"The student "+std.getStdName()+" successfully registered !");
            }
            else{
                JOptionPane.showMessageDialog(null,"The user "+std.getStdName()+" already exists in our records !");
            }
            
        }
        catch(HeadlessException | ClassNotFoundException | SQLException exp){
            JOptionPane.showMessageDialog(null,"There was an error executing insert operation for student.");
        }
    }
}
