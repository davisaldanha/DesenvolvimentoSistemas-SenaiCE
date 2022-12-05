package br.com.DAO;

import br.com.Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ok
 */
public class clienteDAO {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Cliente> lista = new ArrayList<>();
    
    public clienteDAO() throws ClassNotFoundException{
        con = new conexaoDAO().conexaoBD();
    }
    
    public void cadastarCliente(Cliente objetoCliente){
        String sql = "insert into cliente(nome, email, senha) values (?, ?, ?)";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objetoCliente.getNome());
            pstm.setString(2, objetoCliente.getEmail());
            pstm.setString(3, objetoCliente.getSenha());
            
            pstm.execute();
            pstm.close();
           
            
        } catch (Exception e) {
            System.out.println("Cadastrar Cliente: "+e);
        }        
    }
    
    public ArrayList<Cliente> listarCliente(){        
        String sql = "select * from cliente";
        
        try {
           pstm = con.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
               Cliente cliente = new Cliente();
               
               cliente.setId_cliente(rs.getInt("idCliente"));
               cliente.setNome(rs.getString("nome"));
               cliente.setEmail(rs.getString("email"));
               cliente.setSenha(rs.getString("senha"));
                           
               lista.add(cliente);
           }
            
        } catch (Exception e) {
            System.out.println("Listar Cliente: "+e);
        }
        return lista;
    }
    
    public void excluirCliente(Cliente c){
        String sql = "delete from cliente where idCliente=?";
        
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, c.getId_cliente());
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void atualizarCliente(Cliente c){
        String sql = "update cliente set nome=?, email=?, senha=? where idCliente=?";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,c.getNome());
            pstm.setString(2,c.getEmail());
            pstm.setString(3,c.getSenha());
            pstm.setInt(4,c.getId_cliente());
            pstm.execute();
            pstm.close();
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
