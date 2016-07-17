/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Conexao {
    
    private final String driver = "org.gjt.mm.mysql.Driver";
    private final String url = "jdbc:mysql://localhost:3306/contato";
    private final String usuario = "root";
    private final String senha = "06122014";
    private Connection Con;

    public Conexao() {
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        if(Con == null){
            try {
                Con = DriverManager.getConnection(url, usuario, senha);
                // temos que dizer para gravar
                Con.setAutoCommit(false);                
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Con;
    }
    
    public void desconecta(){
        try {
            Con.close();
            Con = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
