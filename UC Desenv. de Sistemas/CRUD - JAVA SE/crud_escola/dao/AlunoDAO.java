package crud_escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import crud_escola.model.Aluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ok
 */

public class AlunoDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs;
    ArrayList<Aluno> lista = new ArrayList<>();
    
    public AlunoDAO(){
        con = new ConnectionFactory().getConexao();
    }
    
    public void createAluno(Aluno aluno){
        String sql =  "insert into aluno(nome, telefone) values(?,?)";
                       
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getTelefone());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cadastrar Aluno" + e);
        }
    }
    
    public ArrayList<Aluno> readyAluno(){
        String sql = "select * from aluno";
        
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setCodigo(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                
                lista.add(aluno);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ready Aluno: " + e);
        }
        
        return lista;
    }
}
