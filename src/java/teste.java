
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class teste {
    
    public static void main(String[] args) {
        try {
            Conexao Con = new Conexao();
            PreparedStatement stm = Con.getConnection().prepareStatement("select * from contato");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("NOME"));
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
