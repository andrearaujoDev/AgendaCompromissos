package br.com.revisaosaulo.controller;

import br.com.revisaosaulo.dao.CompromissoDao;
import br.com.revisaosaulo.dao.ContatoDao;
import br.com.revisaosaulo.domain.Compromisso;
import br.com.revisaosaulo.domain.Contato;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="compromissoMB")
@ViewScoped
public class CompromissoMB {
    
    private Compromisso compromisso = new Compromisso();
    private List<Compromisso> compromissos ;
    private Contato contato = new Contato();
    private String contatoselecionado;
    private List<String> nomes_contato = new ArrayList<>();
    int id_contato = 0;

    public CompromissoMB() {
        this.recuperarContato();
    }
   
    public String inserir(){
        ContatoDao contatoDao = new ContatoDao();
        for(Contato c : contatoDao.listar()){
            if(c.getNome().equals(contatoselecionado)){
                id_contato = c.getId_contato();
            }
        }
        contato = new Contato();
        contato.setId_contato(id_contato);
        compromisso.setContato(contato);
        CompromissoDao compromissoDao = new CompromissoDao();
        if(compromissoDao.inserir(compromisso)){
            return "listadecompromisso.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String alterar(){
        ContatoDao contatoDao = new ContatoDao();
        for(Contato c : contatoDao.listar()){
            if(c.getNome().equals(contatoselecionado)){
                id_contato = c.getId_contato();
            }
        }
        contato = new Contato();
        contato.setId_contato(id_contato);
        compromisso.setContato(contato);
        CompromissoDao compromissoDao = new CompromissoDao();
        if(compromissoDao.alterar(compromisso)){
            return "listadecompromisso.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Compromisso compromisso){
        CompromissoDao compromissoDao = new CompromissoDao();
        if(compromissoDao.excluir(compromisso)){
            return "listadecompromisso.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    //Recupera a sessão atual (CONTATO) Para Obter o ID do usuario
    public void recuperarContato(){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        this.contato = (Contato) session.getAttribute("contato");
    }
    
    //Carrega quando clicar no EDITAR
    public String carregarCompromisso(Compromisso compromisso){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        session.setAttribute("compromisso", compromisso);
        return "editarcompromisso.xhtml?faces-redirect=true";
    }
    //Recupera a sessão Atual(COMPROMISSO)
    public void recuperarCompromisso(){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        this.compromisso = (Compromisso) session.getAttribute("compromisso");
    }
    
    public void listar(){
        CompromissoDao compromissoDao = new CompromissoDao();
        compromissos = compromissoDao.listar();
    }
    
   
    public List<String> get_nomes_contato(){
 	try {
 	 	Connection connection = null;
 	 	Class.forName("com.mysql.jdbc.Driver");
 	 	connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
 	 	PreparedStatement ps = null;
 	 	ps=(PreparedStatement) connection.prepareStatement("select * from contato");
 	 	ResultSet rs=ps.executeQuery();
 	 	while(rs.next()){
 	 	 	nomes_contato.add(rs.getString("nome"));
 	 	}
 	} catch (Exception e) {
 	 	 System.out.println(e);
        }
        return nomes_contato;
    }
    
    
    public String novo(){
        return "adicionarcompromisso.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "listadecompromisso.xhtml?faces-redirect=true";
    }
    
    public String retornarCompromisso(){
        return "/PaginasPrivadas/compromisso/listadecompromisso.xhtml?faces-redirect=true";
    }
    
    public String retornarTelaContato(){
        return "/PaginasPrivadas/contato/listadecontatos.xhtml?faces-redirect=true";
    }

    public Compromisso getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(Compromisso compromisso) {
        this.compromisso = compromisso;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getContatoselecionado() {
        return contatoselecionado;
    }

    public void setContatoselecionado(String contatoselecionado) {
        this.contatoselecionado = contatoselecionado;
    }
    

}
