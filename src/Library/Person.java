package Library;
public class Person {
    String nom;
    String prenom;
    public Person(String n, String p){
        this.nom=n;
        this.prenom=p;
    }
    public void set_nom(String n){
        this.nom=n;
    }
    public void set_prenom(String p){
        this.prenom=p;
    }
    public String get_nom(){
        return this.nom;
    }
    public String get_prenom(){
        return this.prenom;
    }
}
