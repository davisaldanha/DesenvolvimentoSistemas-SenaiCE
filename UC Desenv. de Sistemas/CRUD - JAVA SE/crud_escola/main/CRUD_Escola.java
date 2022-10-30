/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud_escola.main;

import crud_escola.dao.ConnectionFactory;
import crud_escola.view.FormAluno;

/**
 *
 * @author ok
 */
public class CRUD_Escola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionFactory con = new ConnectionFactory();
        con.getConexao();
        
        FormAluno form = new FormAluno();
        form.setVisible(true);
    }
    
}
