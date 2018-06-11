/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.shecemimplementation.model;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author brian-kamau
 */
public abstract class Base {
    Properties properties = new Properties();
    InputStream inputStream;
    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet result = null;
    protected PreparedStatement preparedStatement = null;
    private String DBURL = "jdbc:mysql://localhost:3306/"+getDatabaseCredentials().get(0)+"?useSSL=false";
    
    public boolean getDatabaseConnection(){
        boolean success = true;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DBURL,getDatabaseCredentials().get(1),
                    getDatabaseCredentials().get(2));
            success = true;
        }catch(Exception ex){
            success = false;
            ex.printStackTrace();
        }
        return success;
    }
    public boolean CloseConnection(){
        boolean success= true;
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        }catch(Exception ex){
            success = false;
            ex.printStackTrace();
        }
        return success;
    }
    public ArrayList<String> getDatabaseCredentials(){
        ArrayList<String> databaseDetails = new ArrayList<>();
        try{
            File file = new File("database.properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            databaseDetails.add(properties.getProperty("DATABASE_NAME"));
            databaseDetails.add(properties.getProperty("DATABASE_USERNAME"));
            databaseDetails.add(properties.getProperty("DATABASE_PASSWORD"));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception: " + ex.getMessage());
        }
        return databaseDetails;            
    }    
}
