/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import entities.Reservation;
import entities.Volll;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AfficherResController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private ListView<Reservation> list;
    ReservationService vs=new ReservationService();
    @FXML
    private Button del;
    private Parent fxml;
    Alert alert = new Alert(Alert.AlertType.NONE);

   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Reservation> items =FXCollections.observableArrayList();
        List<Reservation> listuser = vs.afficherRes();
        for(Reservation r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    list.setItems(items);
    }    


   

    @FXML
    private void delete(ActionEvent event) {
       
        
        vs.SupprimerRes(list.getSelectionModel().getSelectedItem().getId());
      ObservableList<Reservation> items =FXCollections.observableArrayList();
        List<Reservation> listuser = vs.afficherRes();
        for(Reservation r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    list.setItems(items);
    }

    @FXML
    private void retourner(ActionEvent event) {
         try{
        fxml=FXMLLoader.load(getClass().getResource("AjouterRes.fxml"));
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
