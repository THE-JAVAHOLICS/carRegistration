/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class mySqlConnect {



    Connection conn = null;
    public static Connection ConnectDb(){
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sde","root","");
         //  JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }  
    }
}


