/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ContatoBean;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ContatoDAO {
    
    private Conexao Con;

    public ContatoDAO() {
    
        Con = new Conexao();
        
    }
    
    public boolean salvarContato(ContatoBean contato){
        
        try {
            String sql="INSERT INTO CONTATO(NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL)"
                    + "VALUES(?,?,?,?,?,?,?);";
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;
        
    }
    
    public boolean editarContato(ContatoBean contato){
        
        try {
            String sql="UPDATE CONTATO SET NOME = ?, ENDERECO = ?, CIDADE = ?, UF = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?"
                    + "WHERE ID = ?;" ;
                    
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEndereco());
            stm.setString(3, contato.getCidade());
            stm.setString(4, contato.getUf());
            stm.setString(5, contato.getTelefone());
            stm.setString(6, contato.getCelular());
            stm.setString(7, contato.getEmail());
            stm.setInt(8, contato.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;
        
    }
    
    public boolean excluirContato(ContatoBean contato){
        
        try {
            String sql="DELTE FROM WHERE ID = ?;" ;
                    
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setInt(1, contato.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;
        
    } 
    
    
    public List<ContatoBean> listarContato(){
        
        List<ContatoBean> lista = new ArrayList<ContatoBean>();
        
        try {
            String sql="SELECT * FROM CONTATO;" ;
                    
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                ContatoBean contato = new ContatoBean();
                contato.setId(rs.getInt("ID"));
                contato.setNome(rs.getString("NOME"));
                contato.setEndereco(rs.getString("ENDERECO"));
                contato.setCidade(rs.getString("CIDADE"));
                contato.setUf(rs.getString("UF"));
                contato.setTelefone(rs.getString("TELEFONE"));
                contato.setCelular(rs.getString("CELULAR"));
                contato.setEmail(rs.getString("EMAIL"));
                lista.add(contato);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista;
        
    } 
    
    
}
