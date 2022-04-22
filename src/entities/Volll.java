/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Reservation;
import entities.Destination;
import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author azizk
 */
public class Volll {
    private int id;
   
    //private Date datevolll;
    private Double prixvolll;
    private LocalDate datevolll;
    
    private Destination destination;
        private Reservation reservation;

    public Volll(int id, LocalDate datevolll, Double prixvolll, Destination destination) {
        this.id = id;
        this.datevolll = datevolll;
        this.prixvolll = prixvolll;
        this.destination = destination;
    }

    public Volll() {
    }

    public Volll(int id) {
        this.id = id;
    }
    

    public Volll(Destination destination) {
        this.destination = destination;
    }

    public Volll(int id, LocalDate datevolll, Double prixvolll) {
        this.id = id;
        this.datevolll = datevolll;
        this.prixvolll = prixvolll;
    }

    public LocalDate getDatevolll() {
        return datevolll;
    }

    public void setDatevolll(LocalDate datevolll) {
        this.datevolll = datevolll;
    }

    public Double getPrixvolll() {
        return prixvolll;
    }

    public void setPrixvolll(Double prixvolll) {
        this.prixvolll = prixvolll;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    
    
    

   

    @Override
    public String toString() {
        return "Vol{ datevolll=" + datevolll + ", prixvolll=" + prixvolll + ",  destination_id=" + id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(ChoiceBox<?> destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   


   
}