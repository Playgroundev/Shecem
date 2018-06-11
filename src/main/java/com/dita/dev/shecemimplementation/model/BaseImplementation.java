/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.shecemimplementation.model;

/**
 *
 * @author brian-kamau
 */
public class BaseImplementation extends Base{
    public boolean testConnection(){
       boolean result = true;
        try{
            result = getDatabaseConnection();
            
        }catch(Exception ex){
            result =false;
            ex.printStackTrace();
        }
        return result;
    }
    
}
