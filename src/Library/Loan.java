/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;
import java.sql.*;
public class Loan {
    Connection conn;
    Statement stm;
    ResultSet rst;
    int id_livre;
    String date_emprunt,date_remettre;
    int id_adherent;
    public Loan(int idl,int id_a,String datee,String dater){
        this.id_livre=idl;
        this.id_adherent=id_a;
        this.date_emprunt=datee;
        this.date_remettre=dater;
    }
    public boolean ajouterLoan(Loan a){
        int i;
        boolean b=false;
        try{
           //Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           String query="INSERT INTO pret(id_livre ,id_adherent, date_emprunt , date_remettre )VALUES ('"+a.id_livre+"','"+a.id_adherent+"','"+a.date_emprunt+"','"+a.date_remettre+"')";
           i =stm.executeUpdate(query); 
           if(i==1){
               b=true;  
           }
          stm.close();
        conn.close();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        }
        
        return b;
    }
    public boolean modifierLoan(Loan a, int id){
        int i;
        boolean b=false;
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
            Statement stm=conn.createStatement();
            //String query="UPDATE pret SET id_livre='"+a.id_livre+"',id_adherent='"+a.id_adherent+"', date_emprunt='"+a.date_emprunt+"', date_remettre='"+a.date_remettre+"' WHERE id_pret='"+id+"'";
            String query="UPDATE pret SET id_livre='"+a.id_livre+"',id_adherent='"+a.id_adherent+"', date_emprunt='"+a.date_emprunt+"', date_remettre='"+a.date_remettre+"' WHERE id_pret='"+id+"' ";
            i =stm.executeUpdate(query); 
            if(i==1){
               b=true;  
           }
          stm.close();
           conn.close();          
        }catch(Exception e){
           System.out.println("Erreur de modification");
        } 
        return b;
    }
        public boolean supprimerLoan(Loan a, int id){
        int i;
        boolean b=false;
        String query="DELETE FROM pret WHERE id_pret='"+id+"'";
        try{
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           i =stm.executeUpdate(query);
           if(i==1)
               b=true;
           stm.close();
           conn.close();
        }catch(Exception e){
            System.out.println("Erreur de suppression");
        }
   return b;}
}
