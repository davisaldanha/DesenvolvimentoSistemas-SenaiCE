package crud_escola.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author ok
 */
public class ConnectionFactory {
    Connection con = null;
    
    public Connection getConexao(){
        try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:33/escola","root","");
            
            if(con != null){
                System.out.println("Conexão com Banco de Dados estabelecida!");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
