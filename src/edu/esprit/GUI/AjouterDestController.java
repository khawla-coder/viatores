/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import entities.Destination;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.DestinationService;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AjouterDestController implements Initializable {
    private Parent fxml;
    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
    

    @FXML
    private TextField txtDep;
    @FXML
    private TextField txtArr;
    @FXML
    private Button ajout;
    DestinationService vs=new DestinationService();
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button retu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        ObservableList<Destination> list=FXCollections.observableArrayList();
       
       Connection cnx = MaConnexion.getInstance().getCnx();
   
         
        
    }

    @FXML
    private void addDest(ActionEvent event) {
        
        boolean test=vs.getDestinationByVilleArr(txtArr.getText()) == false || vs.getDestinationByVilleDep(txtDep.getText()) == false;
        if (txtDep.getText().isEmpty() == false && txtArr.getText().isEmpty() == false &&test)
               {
                   
               
             Destination u = new Destination(0, txtDep.getText(), txtArr.getText());

            vs.ajouterDestination(u);

            System.out.println("ajout");
            JOptionPane.showMessageDialog(null, "AJOUT destination  DONE");
           AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("afficherDestination.fxml"));
            mainPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
                    
        }
              
} else {
            JOptionPane.showMessageDialog(null, "erreur !!!   remplir Correctement les champs  ");
        }
    
       
        
    
}

    @FXML
    private void Rett(ActionEvent event) {
         try{
        fxml=FXMLLoader.load(getClass().getResource("interface.fxml"));
        mainPane.getChildren().removeAll();
        mainPane.getChildren().setAll(fxml);
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    }
    
    
    
     /**  @FXML
    private void addDest(ActionEvent event) throws IOException {
        if (txtDep.getText().isEmpty() == false && txtArr.getText().isEmpty() == false)
        {
        String ville_dep = txtDep.getText();
        String ville_arr = txtArr.getText();
        DestinationService ps = new DestinationService();
        ps.ajouterDestination(new Destination(ville_dep, ville_arr));
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("afficherDestination.fxml"));
        Parent root = loader.load();
            AfficherDestinationController ac = 
                    loader.getController();
            
            
           
       
    
          JOptionPane.showMessageDialog(null, "AJOUT destination  DONE");
           AnchorPane pane;
            
           } else {
            JOptionPane.showMessageDialog(null, "erreur !!! remplir Correctement les champs");
        }**/
    

   

