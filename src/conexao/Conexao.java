package conexao;
import java.sql.*;

public class Conexao {
    
    String usuario;
    String senha;
    String url;
    String driver;
    Connection con;
    
    public Connection conector(){
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/hospital";
        usuario = "root";
        senha = "32482705";
        
        try{
            
            Class.forName(driver);
            con = DriverManager.getConnection(url,usuario,senha);
            
        }catch (ClassNotFoundException e){
            
            e.printStackTrace();
            
        }catch (SQLException sqle) {
            
            sqle.printStackTrace();
            
        }
        return con;
    }
}
