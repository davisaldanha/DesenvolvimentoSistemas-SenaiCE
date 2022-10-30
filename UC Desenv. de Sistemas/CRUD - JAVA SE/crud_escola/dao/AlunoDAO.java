package crud_escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import crud_escola.model.Aluno;
import javax.swing.JOptionPane;

/**
 *
 * @author ok
 */

public class AlunoDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    
    public AlunoDAO(){
        con = new ConnectionFactory().getConexao();
    }
    
    public void createAluno(Aluno aluno){
        String sql =  "insert into aluno(idAluno, nome, telefone) values(?,?,?)";
                       
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, aluno.getCodigo());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, aluno.getTelefone());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cadastrar Aluno" + e);
        }
    }
}
