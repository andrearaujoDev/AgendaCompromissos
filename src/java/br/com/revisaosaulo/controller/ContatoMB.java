package br.com.revisaosaulo.controller;

import br.com.revisaosaulo.dao.ContatoDao;
import br.com.revisaosaulo.domain.Contato;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "contatoMB")
@ViewScoped
public class ContatoMB {
    private Contato contato = new Contato();
    private List<Contato> contatos ;
    
    public ContatoMB() {
        
    }

    public ContatoMB(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String inserir(){
        ContatoDao contatoDao = new ContatoDao();
        if(contatoDao.inserir(contato)){
            return "listadecontato.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String alterar(){
        ContatoDao contatoDao = new ContatoDao();
        if(contatoDao.alterar(contato)){
            return "listadecontato.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Contato contato){
        ContatoDao contatoDao = new ContatoDao();
        if(contatoDao.excluir(contato)){
            return "listadecontato.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    //Carregar quando clicar no EDITAR
    public String carregarDadosContato(Contato contato){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        session.setAttribute("contato", contato);
        return "editarcontato.xhtml?faces-redirect=true";
    }
    // Recupera a Sessão atual (CONTATO)
    public void recuperarContato(){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        this.contato = (Contato) session.getAttribute("contato");
    }
    
    //Carregar quando clicar no COMPROMISSO
    public String carregarDadosCompromisso(Contato contato){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        session.setAttribute("contato", contato);
        return "/PaginasPrivadas/compromisso/listadecompromisso.xhtml?faces-redirect=true";
        
    }
    
    public void listar(){
        ContatoDao contatoDao = new ContatoDao();
        contatos = contatoDao.listar();
    }
    
    public void listarStrings(){
        ContatoDao contatoDao = new ContatoDao();
        contatos = contatoDao.listar();
    }
    
    public String novo(){
        return "adicionarcontato.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "listadecontato.xhtml?faces-redirect=true";
    }
    
    public String retornarCompromisso(){
        return "/PaginasPrivadas/compromisso/listadecompromisso.xhtml?faces-redirect=true";
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    
    
}
