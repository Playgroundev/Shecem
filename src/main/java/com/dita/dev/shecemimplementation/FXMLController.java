package com.dita.dev.shecemimplementation;

import com.dita.dev.shecemimplementation.model.BaseImplementation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    BaseImplementation baseImplementation = new BaseImplementation();
   /* @FXML
    private Label label;*/
   @FXML private JFXButton checkDatabase;
   @FXML private JFXProgressBar SpinnerBtn;
   @FXML private void checkData(ActionEvent event){
       System.out.println("Testing DatabaseConnection");
       SpinnerBtn.setVisible(true);
       try{
           if(baseImplementation.testConnection()){
               checkDatabase.setText("Success"); 
              // Thread.sleep(500);
              // SpinnerBtn.setVisible(false);
               
           }else {
               checkDatabase.setText("Failed");
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
  /*  @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
       public Task createWorker(){
        return new Task(){
            @Override
            protected Object call() throws Exception {
                for(int i = 0;i<10;i++){
                    Thread.sleep(500);
                    updateMessage("500 Milliseconds");
                    updateProgress(i+1,10);
                    SpinnerBtn.setVisible(true);
                }
               return true;
            }  
        }; 
    }
}
