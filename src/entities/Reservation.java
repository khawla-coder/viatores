package entities;

import entities.Volll;

public class Reservation {
    private int id;
    private String nom,prenom;
    private Volll vol;

    public Reservation() {
    }

    public Reservation(Volll vol) {
        this.vol = vol;
    }
    
    

    public Reservation(int id, String nom, String prenom,Volll vol) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.vol= vol;
    }
     public Reservation( String nom, String prenom,Volll vol) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.vol= vol;
    }

    public Volll getVol() {
        return vol;
    }

    public void setVol(Volll vol) {
        this.vol = vol;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "reservation{ nom=" + nom + ", prenom=" + prenom +", vols_id=" + id + '}';
    }
    
    
    
}

