/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class InterfaceController implements Initializable {

    private Parent fxml;
    
    
    @FXML
    private AnchorPane minPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

   

    @FXML
    private void addDest(MouseEvent event) {
        try{
        fxml=FXMLLoader.load(getClass().getResource("AjouterDest.fxml"));
        minPane.getChildren().removeAll();
        minPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    
    }

    @FXML
    private void reserver(MouseEvent event) {
        try{
        fxml=FXMLLoader.load(getClass().getResource("AjouterRes.fxml"));
        minPane.getChildren().removeAll();
        minPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void addV(ActionEvent event) {
         try{
        fxml=FXMLLoader.load(getClass().getResource("AjouterVol.fxml"));
        minPane.getChildren().removeAll();
        minPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
