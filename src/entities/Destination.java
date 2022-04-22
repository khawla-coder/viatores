package entities;

import entities.Volll;



/**
 *
 * @author azizk
 */
public class Destination {
    private int id;
    private String ville_dep;
    private String ville_arr;
    private Volll vol;

    public Destination() {
    }

    

    public Destination(int id, String ville_dep, String ville_arr, Volll vol) {
        this.id = id;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
        this.vol = vol;
    }

    public Destination(int id) {
        this.id = id;
    }
    
  

    public Destination(int id, String ville_dep, String ville_arr) {
        this.id = id;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
    }

    public Destination(Volll vol) {
        this.vol = vol;
    }

    public Destination(String ville_dep, String ville_arr) {
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
    }

    

    public String getVille_dep() {
        return ville_dep;
    }

    public void setVille_dep(String ville_dep) {
        this.ville_dep = ville_dep;
    }

    public String getVille_arr() {
        return ville_arr;
    }

    public void setVille_arr(String ville_arr) {
        this.ville_arr = ville_arr;
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

  
    @Override
    public String toString() {
        return "destination{ ville_dep=" + ville_dep + ", ville_arr=" + ville_arr + '}';
    }

  


   
}