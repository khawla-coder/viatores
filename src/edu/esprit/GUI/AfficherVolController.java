/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import entities.Destination;
import entities.Volll;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.VolService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AfficherVolController implements Initializable {
    Alert alert = new Alert(Alert.AlertType.NONE);

    @FXML
    private ListView<Volll> list;
VolService vs=new VolService();
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button del;
    @FXML
    private ChoiceBox<Integer> destination;
    @FXML
    private DatePicker date;
    @FXML
    private TextField prix;
    VolService ds=new VolService();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Volll> items =FXCollections.observableArrayList();
        List<Volll> listuser = vs.afficherVol();
        for(Volll r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    list.setItems(items);
    }    


   

    @FXML
    private void delete(ActionEvent event) {
        
        vs.SupprimerVol(list.getSelectionModel().getSelectedItem().getId());
      ObservableList<Volll> items =FXCollections.observableArrayList();
        List<Volll> listuser = vs.afficherVol();
        for(Volll r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    list.setItems(items);
    }

    @FXML
    private void modifierVol(ActionEvent event) {
         Volll emp = new Volll();
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous vraiment modifier ce vol");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            if (prix.getText().equals("") || date.getValue().equals("")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("champs manquants !");
                alert.showAndWait();
            
            } else {
                emp.setDestination(destination);
                double str1 = Double.valueOf(prix.getText());
                emp.setPrixvolll(str1);
                LocalDate d=date.getValue();
                emp.setDatevolll(d);

                Volll empID = list.getSelectionModel().getSelectedItem();
                emp.setId(empID.getId());

                ds.ModifierVol(emp);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("modification effectuée avec succée!");
                alert.show();
                ObservableList<Volll> items =FXCollections.observableArrayList();
                List<Volll> listuser = ds.afficherVol();
                for(Volll r : listuser) {
                String ch = r.toString();
                items.add(r);
                }
       
                list.setItems(items);
                //refresh2();

                prix.setText("");
                date.setValue(null);
                destination.setValue(null);
                

            }
        } 
    }

    @FXML
    private void GetDataDest(MouseEvent event) {
        
           Volll loc = new Volll();
          list.setOnMouseClicked((event1) -> {
           // int selectedIdUser = ListLoc.getSelectionModel().getSelectedItem().getIdUser();
            Double selectedPrix = list.getSelectionModel().getSelectedItem().getPrixvolll();
            LocalDate selectedDate = list.getSelectionModel().getSelectedItem().getDatevolll();
            // float selectedDuree = ListLoc.getSelectionModel().getSelectedItem().getDuree();
            //int selectedIDABON = list.getSelectionModel().getSelectedItem().getIdAbonnement();
            int selectedId = list.getSelectionModel().getSelectedItem().getDestination().getId();

           
            //TextIdUserLoc.setText(String.valueOf(selectedIdUser));
            prix.setText(String.valueOf(selectedPrix));
             date.setValue(selectedDate);
             //TextDuree.setText(String.valueOf(selectedDuree));
              destination.setValue(Integer.valueOf(selectedId));
             // TextHeureLoc.setText(selectedHeure);
              
        });
        
        
    }
}
    
    

    

