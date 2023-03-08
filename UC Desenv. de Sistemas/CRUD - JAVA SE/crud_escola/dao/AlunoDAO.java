package crudescola.dao;
/**
 *
 * @author dssaldanha
 */
import crudescola.model.Aluno;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunoDAO {
   
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Aluno> lista = new ArrayList<>();
    
    public AlunoDAO(){
        conexao = new ConnectionFactory().getConexao();
    }
   
    public void createAluno(Aluno aluno){
       String sql = "insert into aluno(nome, telefone) values(?, ?)";
       
       try{
        pstm = (PreparedStatement) conexao.prepareStatement(sql);
        pstm.setString(1,aluno.getNome());
        pstm.setString(2, aluno.getTelefone());
        pstm.execute();
        pstm.close();
        
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Cadastrar aluno: " + e);
       }
             
    }
    
    public ArrayList<Aluno> readyAluno(){
        String sql = "select * from aluno";
        
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                
                lista.add(aluno);
            }              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ready Aluno: " + e);
        }
        return lista;
    }
    
    public ArrayList<Aluno> searchAluno(String descricao){
        String sql = "select * from aluno where nome like '%"+descricao+"%'";
        
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                
                lista.add(aluno);
            }              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ready Aluno: " + e);
        }
        return lista;
    }
    
    public void updateAluno(Aluno aluno){
       String sql = "update aluno set nome=?, telefone=? where idAluno=?";
       
       try{
        pstm = (PreparedStatement) conexao.prepareStatement(sql);
        pstm.setString(1,aluno.getNome());
        pstm.setString(2, aluno.getTelefone());
        pstm.setInt(3, aluno.getId());
        pstm.execute();
        pstm.close();
        
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Alterar aluno: " + e);
       }
    }
    
    public void deleteAluno(Aluno aluno){
        String sql = "delete from aluno where idAluno=?";
        
        try {
            pstm = (PreparedStatement) conexao.prepareStatement(sql);
            pstm.setInt(1, aluno.getId());
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deletar aluno: " + e);
        }
    }
    
    
}
