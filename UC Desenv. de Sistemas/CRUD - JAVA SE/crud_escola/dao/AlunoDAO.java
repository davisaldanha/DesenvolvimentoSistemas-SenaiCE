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
}
