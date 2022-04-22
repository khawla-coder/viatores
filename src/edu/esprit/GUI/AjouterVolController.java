/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import entities.Volll;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.VolService;
import tools.MaConnexion;

/**
 *
 * @author PC
 */
public class AjouterVolController implements Initializable{
    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
    

    @FXML
    private TextField txtPrix;

    @FXML
    private DatePicker txtDate;
    
    public ObservableList<Volll> data=FXCollections.observableArrayList();

    
    ObservableList<Volll> list=FXCollections.observableArrayList();

    @FXML
    private Button AjouterButton;
    @FXML
    private ChoiceBox<Integer> Dest;
    
    VolService vs=new VolService();
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button ret;
    private Parent fxml;

    @FXML
    void addVol() throws IOException {
         double str1 = Double.valueOf(txtPrix.getText());
        if (txtPrix.getText().isEmpty() == false && vs.getVolParDate(txtDate.getValue())==false && vs.getVolParPrix(str1)==false)
               {
                   
               
            Volll u = new Volll(0, txtDate.getValue(), str1, vs.getuserbyID(Dest.getValue()));

            vs.ajouterVol(u);

            System.out.println("ajout");
            JOptionPane.showMessageDialog(null, "AJOUT vol  DONE");
           AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("afficherVol.fxml"));
            mainPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
                    
        }
              
} else {
            JOptionPane.showMessageDialog(null, "erreur !!! remplir Correctement les champs");
        }
    
       
        
    }
    

    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         ObservableList<Integer> langs = FXCollections.observableArrayList(vs.getIdDest());
         Dest.setItems(langs);
       
         cnx =MaConnexion.getInstance().getCnx();
     
         
        
    }

    @FXML
    private void retourner(ActionEvent event) {
        
         try{
        fxml=FXMLLoader.load(getClass().getResource("interface.fxml"));
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
