package br.com.revisaosaulo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="contato")
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_contato;
    @NotNull
    @Column(name="nome")
    @Size(min=1,max=20)
    private String nome;
    @NotNull
    @Column(name="telefone")
    @Size(min=1,max=20)
    private String telefone;
    @NotNull
    @Column(name="email")
    @Size(min=1,max=20)
    private String email;
    @NotNull
    @Column(name="data_nasc")
    @Size(min=1,max=20)
    private String data_nasc;
    @OneToMany(mappedBy="id_co")
    private List<Compromisso> compromisso;

    public Contato() {
    
    }

    public Contato(int id_contato, String nome, String telefone, String email, String data_nasc, List<Compromisso> compromisso) {
        this.id_contato = id_contato;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.data_nasc = data_nasc;
        this.compromisso = compromisso;
    }

    
    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public List<Compromisso> getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(List<Compromisso> compromisso) {
        this.compromisso = compromisso;
    }
    
}
