/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Destination;
import entities.Volll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tools.MaConnexion;

/**
 *
 * @author PC
 */
public class VolService {
     Connection cnx;

    public VolService() {
        cnx =MaConnexion.getInstance().getCnx();
    }
    
    
   
     public void SupprimerVol(int c){
          try {
              String req = "DELETE from volll  WHERE id =" +c+ " ";
              
              Statement ste = cnx.createStatement();
              ste.executeUpdate(req);
              System.out.println("done");
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
    public void ajouterVol(Volll c) {
       
         
              String req = "insert into volll (destination_id,datevolll,prixvolll) values (?,?,?)";
              try { 
              
              PreparedStatement pst = cnx.prepareStatement(req);
              pst.setInt(1, c.getDestination().getId());
              pst.setDate(2, Date.valueOf(LocalDate.now()));
              pst.setDouble(3, c.getPrixvolll());
              
              pst.executeUpdate();
              System.out.println("Vol Ajouté !!");
              
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
              
              public List<Volll> afficherVol(){
        List<Volll> Volll = new ArrayList<>();
        String sql="select * from volll";
        Statement ste;
       
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
             while(rs.next()){
                 Volll c = new Volll();
                 
                 c.setId(rs.getInt("id"));
                 
                 Date date = rs.getDate("datevolll");
                c.setDatevolll(date.toLocalDate());
                
       
                 c.setPrixvolll(rs.getDouble("prixvolll"));
                 c.setDestination(new Destination(rs.getInt("destination_id")));

                 Volll.add(c);
                 
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return Volll;
    }

   
    
    
     
      public void ModifierVol(Volll e) {
        
        try {
            String req = "UPDATE volll SET  destination_id= ?, datevolll = ?, prixvolll = ? WHERE id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);

          
           ps.setInt(1, e.getDestination().getId());
            ps.setDate(2, Date.valueOf(e.getDatevolll()));
            ps.setDouble(3, e.getPrixvolll());
            ps.setInt(4, e.getId());
           

            
            ps.executeUpdate();
         System.out.println("Vol modifié");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        } 
        }
       public List<Integer> getIdDest() {
        List<Integer> destinations = new ArrayList<>();
        String query = "select * from volll";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);

            while (rs.next()) {
 destinations.add(rs.getInt(1));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return destinations;
    }

public Destination getuserbyID(int id) {
         String sql = "SELECT * FROM destination where id=" + id + "";
         
          Destination p =new Destination();
         Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);

            while (rs.first()) {
                    
                p.setId(rs.getInt("id"));
                p.setVille_dep(rs.getString(2));
                p.setVille_arr(rs.getString("ville_arr"));
               
                
                    return p;
 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(p);
        return p;
}
      public boolean getVolParDate(LocalDate date) {
        boolean exist = false;

        try {
            String sql = "SELECT * FROM volll where datevolll=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setDate(1, Date.valueOf(date));
          

            ResultSet rs = ste.executeQuery();//resultat requete sql
            if (rs.first()) {
                exist = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exist;

    }
       public boolean getVolParPrix(Double prix) {
        boolean exist = false;

        try {
            String sql = "SELECT * FROM volll where prixvolll=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setDouble(1,prix );
          

            ResultSet rs = ste.executeQuery();//resultat requete sql
            if (rs.first()) {
                exist = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exist;

    }

        
  }

