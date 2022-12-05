package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ok
 */
public class conexaoDAO {
    
    Connection con = null;
    
    public Connection conexaoBD() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:33/sistemacliente","root",""); 
        }catch(SQLException e){
            System.out.println(e); 
        }

        return con;
    }
}
