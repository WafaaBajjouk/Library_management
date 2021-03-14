package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Book {
    
        String titre, nom_auteur,lieu_edition,date_edition,quantite;

    public Book(String titre, String nom_auteur, String lieu_edition, String date_edition, String quantite) {
        
        this.titre = titre;
        this.nom_auteur = nom_auteur;
        this.lieu_edition = lieu_edition;
        this.date_edition = date_edition;
        this.quantite = quantite;
    }
    
        

    public boolean ajouterBook(Book a){
        int i;
        boolean b=false;
        try{
           //Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           String query="INSERT INTO livre(titre , nom_auteur,lieu_edition , date_edition , quantite )VALUES ('"+a.titre+"','"+a.nom_auteur+"','"+a.lieu_edition+"','"+a.date_edition+"','"+a.quantite+"')";
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
    public boolean modifierBook(Book a, String id){
        int i;
        boolean b=false;
        try{
           //Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           Statement stm=conn.createStatement();
           //String query="UPDATE livre SET titre='"+a.titre+"', nom_auteur='"+a.nom_auteur+"', date_edition='"+a.date_edition+"',lieu_edition='"+a.lieu_edition+"',quantite='"+a.quantite+"' WHERE CONVERT (id_livre,VARCHAR(10)='"+id+"'";
           String query="UPDATE livre SET titre='"+a.titre+"',nom_auteur='"+a.nom_auteur+"', lieu_edition='"+a.lieu_edition+"', date_edition='"+a.date_edition+"',quantite='"+a.quantite+"' WHERE CONVERT(id_livre,varchar(10))='"+id+"' ";
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
    public boolean supprimerBook(Book a, String id){
        int i;
        boolean b=false;
        String query="DELETE FROM livre WHERE CONVERT(id_livre,varchar(10))='"+id+"'";
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