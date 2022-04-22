package services;

import entities.Destination;
import entities.Reservation;
import entities.Volll;
import tools.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    Connection cnx;

    public ReservationService() {
        cnx =MaConnexion.getInstance().getCnx();
    }
    
   
     public void ajouterRes(Reservation c) {
       
         
              String req = "insert into reservation (vols_id,nom,prenom) values (?,?,?)";
              try { 
              
              PreparedStatement pst = cnx.prepareStatement(req);
              pst.setInt(1, c.getVol().getId());
              pst.setString(2,c.getNom());
              pst.setString(3,c.getPrenom());
              
              pst.executeUpdate();
              System.out.println("Reservation Ajouté !!");
              
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
   public List<Reservation> afficherRes(){
        List<Reservation> Reservation = new ArrayList<>();
        String sql="select * from reservation";
        Statement ste;
       
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
             while(rs.next()){
                 Reservation c = new Reservation();
                 
                 c.setId(rs.getInt("id"));
                 
                 c.setNom(rs.getString("nom"));
                  c.setPrenom(rs.getString("prenom"));
                
       
                 
               c.setVol(new Volll(rs.getInt("vols_id")));

                 Reservation.add(c);
                 
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return Reservation;
    }
 public void ModifierRes(Reservation c) {
        
        try {
            String req = "UPDATE reservation SET  vols_id= ?, nom = ?, prenom = ? WHERE id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);

          
          ps.setInt(1, c.getVol().getId());
              ps.setString(2,c.getNom());
              ps.setString(3,c.getPrenom());
            ps.setInt(4, c.getId());
           

            
            ps.executeUpdate();
         System.out.println("reservation modifiée");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        }
   public void SupprimerRes(int c){
          try {
              String req = "DELETE from reservation  WHERE id =" +c+ " ";
              
              Statement ste = cnx.createStatement();
              ste.executeUpdate(req);
              System.out.println("done");
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
  public List<Integer> getIdDest() {
        List<Integer> volll = new ArrayList<>();
        String query = "select * from volll";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);

            while (rs.next()) {
 volll.add(rs.getInt(1));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return volll;
    }

public Volll getuserbyID(int id) {
         String sql = "SELECT * FROM volll where id=" + id + "";
         
          Volll p =new Volll();
         Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);

            while (rs.first()) {
                    
               Volll c = new Volll();
                 
                 c.setId(rs.getInt("id"));
                 
                 Date date = rs.getDate("datevolll");
                c.setDatevolll(date.toLocalDate());
                
       
                 c.setPrixvolll(rs.getDouble("prixvolll"));
                 c.setDestination(new Destination(rs.getInt("destination_id")));
               
                
                    return p;
 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(p);
        return p;
}
    
    
    
}
