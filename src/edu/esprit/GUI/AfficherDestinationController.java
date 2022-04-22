package edu.esprit.GUI;

import entities.Destination;
import entities.Volll;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.DestinationService;
import services.VolService;

/**
 * FXML Controller class
 *
 * @author Fayechi
 */
public class AfficherDestinationController implements Initializable {

    
    DestinationService ds=new DestinationService();
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ListView<Destination> List;
    @FXML
    private TextField recherche;
    @FXML
    private Button ModDest;
  
Alert alert = new Alert(Alert.AlertType.NONE);
    @FXML
    private TextField txtVD;
    @FXML
    private TextField txtVA;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Destination> items =FXCollections.observableArrayList();
        List<Destination> listuser = ds.afficherDestination();
        for(Destination r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    List.setItems(items);
    }    


   

    @FXML
    private void delete(ActionEvent event) {
        
        ds.SupprimerDestination(List.getSelectionModel().getSelectedItem().getId());
      ObservableList<Destination> items =FXCollections.observableArrayList();
        List<Destination> listuser = ds.afficherDestination();
        for(Destination r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    List.setItems(items);
    }

    void setList(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void findDest(ActionEvent event) {
        ObservableList<Destination> items =FXCollections.observableArrayList();
        List<Destination> listuser = ds.afficherDestination();
          Set<Destination> li =  ds.Rechercher(listuser, recherche.getText());
        for(Destination r : li) {
            String ch = r.toString();
            items.add(r);
        }
       
    List.setItems(items);
    if(recherche.getText().equals(""))
    { List<Destination> ttt = ds.afficherDestination();
        for(Destination r : ttt) {
            String ch = r.toString();
            items.add(r);
        }
       
    List.setItems(items);

    }
        
    }

    @FXML
    private void modifierDestination(ActionEvent event) throws SQLException {
     
        Destination emp = new Destination();
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous vraiment modifier cet Emplacement");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            if (txtVD.getText().equals("") || txtVA.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("champs manquants !");
                alert.showAndWait();
            
            } else {
                emp.setVille_dep(txtVD.getText());
                emp.setVille_arr(txtVA.getText());

                Destination empID = List.getSelectionModel().getSelectedItem();
                emp.setId(empID.getId());

                ds.ModifierDestination(emp);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("modification effectuée avec succée!");
                alert.show();
ObservableList<Destination> items =FXCollections.observableArrayList();
        List<Destination> listuser = ds.afficherDestination();
        for(Destination r : listuser) {
            String ch = r.toString();
            items.add(r);
        }
       
    List.setItems(items);
                //refresh2();

                txtVA.setText("");
                txtVD.setText("");

            }
        } 
    }

    @FXML
    private void GetDataDest(MouseEvent event) {
         Destination dest = new Destination();
          List.setOnMouseClicked((event1) -> {

            String selectedArr = List.getSelectionModel().getSelectedItem().getVille_arr();
            String selectedDep = List.getSelectionModel().getSelectedItem().getVille_dep();

           
            txtVA.setText(String.valueOf(selectedArr));
             txtVD.setText(String.valueOf(selectedDep));

              
        });
    }
  
}

