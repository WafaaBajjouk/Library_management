/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Library;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zakaria AIT ERRAMI
 */
public class Adherent extends Person{
    String email, tele,username,password;
    String date_n;
    public Adherent(String n, String p, String em, String tel,String daten, String user, String pas) {
        super(n,p);
        this.email=em;
        this.tele=tel;
        this.date_n=daten;
        this.username=user;
        this.password=pas;
    }
    public boolean ajouteradherent(Adherent a){
        int i;
        boolean b=false;
        try{
           //Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           String query="INSERT INTO adherent (nom,prenom,date_n,tele,email,username,password) VALUES ('"+a.nom+"','"+a.prenom+"','"+a.date_n+"','"+a.tele+"','"+a.email+"','"+a.username+"','"+a.password+"')";
           i =stm.executeUpdate(query); 
           if(i==1){
               b=true;  //return true if the statement has been executed
           }
          stm.close();
        conn.close();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        }
        
        return b;
    }
    public boolean modifieradherent(Adherent a, String id){
        int i;
        boolean b=false;
        try{
           //Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           String query="UPDATE adherent SET nom='"+a.nom+"', prenom='"+a.prenom+"', username='"+a.username+"',password='"+a.prenom+"',email='"+a.email+"', tele='"+a.tele+"', date_n='"+a.date_n+"' WHERE CONVERT(id_adherent,varchar(10))='"+id+"' ";
           i =stm.executeUpdate(query); 
           if(i==1){
               b=true;  //return true if the statement has been executed
           }
          stm.close();
        conn.close();
       }catch(Exception e){
           System.out.println("Erreur de modification");
        }        
    return b;
    }
    public boolean supprimeradherent(Adherent a, String id){
        int i;
        boolean b=false;
        String query="DELETE FROM adherent WHERE CONVERT(id_adherent,varchar(10))='"+id+"'";
        try{
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           i =stm.executeUpdate(query);
           if(i==1)
               b=true;
           stm.close();
           conn.close();
        }catch(Exception e){
            System.out.println("Erreur de modification");
        }
   return b;}
}
