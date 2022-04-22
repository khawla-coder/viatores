/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import entities.Reservation;
import entities.Volll;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.ReservationService;
import services.VolService;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ReserverVolController implements Initializable {
     private Parent fxml;

    @FXML
    private Label labAjout;
    @FXML
    private Button idRés;
    @FXML
    private ChoiceBox<Integer> Res;
     ReservationService vs=new ReservationService();
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Integer> langs = FXCollections.observableArrayList(vs.getIdDest());
         Res.setItems(langs);
       
        Connection cnx = MaConnexion.getInstance().getCnx();
     
         
        
    }
    

    @FXML
    private void addRés(ActionEvent event) {
         if (nom.getText().isEmpty() == false&&prenom.getText().isEmpty() == false)
               {
                   
               
            Reservation u = new Reservation(0, nom.getText(), prenom.getText(), vs.getuserbyID(Res.getValue()));

            vs.ajouterRes(u);

            System.out.println("ajout");
            JOptionPane.showMessageDialog(null, "AJOUT reservation  DONE");
           AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("afficherRes.fxml"));
            mainPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
                    
        }
              
} else {
            JOptionPane.showMessageDialog(null, "erreur !!! remplir Correctement les champs");
        }
    
       
        
    }

    @FXML
    private void retVol(ActionEvent event) {
         try{
        fxml=FXMLLoader.load(getClass().getResource("interface.fxml"));
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    }
    
  

