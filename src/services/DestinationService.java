/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Destination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import tools.MaConnexion;


/**
 *
 * @author PC
 */
public class DestinationService {
     Connection cnx;

    public DestinationService() {
        cnx =MaConnexion.getInstance().getCnx();
    }
 
 public void ajouterDestination(Destination p){
        String query ="insert into destination(ville_dep,ville_arr) values(?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.setString(1, p.getVille_dep());
            ste.setString(2, p.getVille_arr());
            ste.executeUpdate();
            System.out.println("Destination Ajoutée !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
 public List<Destination> afficherDestination(){
        List<Destination> destination = new ArrayList<>();
        String sql ="select * from destination";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Destination p = new Destination();
                p.setId(rs.getInt("id"));
                p.setVille_dep(rs.getString(2));
                p.setVille_arr(rs.getString("ville_arr"));
                destination.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return destination;
        
    }
        

    
    
        public void SupprimerDestination(int c){
          try {
              String req = "DELETE from destination  WHERE id =" +c+ " ";
              
              Statement ste = cnx.createStatement();
              ste.executeUpdate(req);
              System.out.println("done");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        public void ModifierDestination(Destination c)
        { String req ="UPDATE destination set ville_dep=? , ville_arr=? WHERE id =? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);             
            //pst.setInt(1, c.getJeu().getId());
              pst.setString(1, c.getVille_dep());
              pst.setString(2, c.getVille_arr());
                   pst.setInt(3, c.getId());
             // pst.setDate(4, Date.valueOf(c.getDatev()));
             // pst.setTime(5, Time.valueOf(c.getHeurev()));
             // pst.setString(6, c.getImage());
              pst.executeUpdate();
              System.out.println("Destination modifiée");
            
        } catch (SQLException ex) {
           
            System.out.println(ex.getMessage());
            
        } 
        
    
}
        
        public boolean getDestinationByVilleDep(String villeDep) {
        boolean exist = false;

        try {
            String sql = "SELECT * FROM destination where ville_dep=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, villeDep);

            ResultSet rs = ste.executeQuery();//resultat requete sql
            if (rs.first()) {
                exist = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exist;

    }
        
        
         public boolean getDestinationByVilleArr(String villeArr) {
        boolean exist = false;

        try {
            String sql = "SELECT * FROM destination where ville_arr=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, villeArr);

            ResultSet rs = ste.executeQuery();//resultat requete sql
            if (rs.first()) {
                exist = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exist;

    }
         /**public void Rechercher( List<Destination> destination, String ville_dep){
       
        
         destination.stream().filter(cc->cc.getVille_dep().equals(ville_dep)).forEach((t) -> {System.out.println(t);
        });
    }**/
         public Set<Destination> Rechercher( List<Destination> destination, String ville_dep){
       
        Set<Destination> u=destination.stream().filter(cc->cc.getVille_dep().equals(ville_dep)).collect(Collectors.toCollection(()->new TreeSet<Destination>((e1,e2)->e1.getVille_dep().compareTo(e2.getVille_dep()))));
        
         return u;
    }

         
 public void TriDest(List<Destination> destination){
        
        destination.stream().sorted((o1, o2)->o1.getVille_dep().
                                                                compareTo(o2.getVille_dep())).
                                                                collect(Collectors.toList()).forEach(t-> System.out.println(t));
        
    }
}