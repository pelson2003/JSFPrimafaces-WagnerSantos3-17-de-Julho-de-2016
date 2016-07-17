/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.ContatoBean;
import DAO.ContatoDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author User
 */

@ManagedBean
@SessionScoped
public class ContatoController implements Serializable {
    
    private ContatoBean contatoB;
    private DataModel listaContatos;

    public ContatoController() {
        contatoB = new ContatoBean();
    }

    /**
     * @return the contatoB
     */
    public ContatoBean getContatoB() {
        return contatoB;
    }

    /**
     * @param contatoB the contatoB to set
     */
    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }

    /**
     * @return the listaContatos
     */
    public DataModel getListaContatos() {
        ContatoDAO cD = new ContatoDAO();
        listaContatos = new ListDataModel(cD.listarContato());
        return listaContatos;
    }

    /**
     * @param listaContatos the listaContatos to set
     */
    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    public void novoContato(){
        contatoB = new ContatoBean();
    }
    
    public String salvaContato(){
        ContatoDAO cD = new ContatoDAO();
        if(cD.salvarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CADASTRADO COM SUCESSO", ""));
            return "listarcontatos";
        }
        return "erro";
    }
    
        public String editarContato(){
        ContatoDAO cD = new ContatoDAO();
        if(cD.editarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO COM SUCESSO", ""));
            return "listarcontatos";
        }
        return "erro";
        }
    
        public String excluirContato(){
        ContatoDAO cD = new ContatoDAO();
        if(cD.excluirContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUIDO COM SUCESSO", ""));
            return "listarcontatos";
        }
        return "erro";
    }
        
        
    }
    

