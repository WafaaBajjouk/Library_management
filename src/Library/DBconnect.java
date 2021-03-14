package Library;
import java.sql.*;
public class DBconnect {
    public Connection conn;
    public Statement stm;
    public ResultSet rst;
    public DBconnect(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3325/library","root","");
           stm=conn.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        }         
    }
    public boolean verify(String user,String pass) throws SQLException{
        boolean flag=false;
        String query="SELECT * FROM useradmin WHERE username=? AND password=?";
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, user);
        pst.setString(2, pass);
        rst=pst.executeQuery(query);
        if(rst.next()){
            flag=true;
        }
    return flag;}
}
