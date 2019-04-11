package br.com.revisaosaulo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="compromissos")
public class Compromisso implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_co;
    @NotNull
    @Column(name="data_co")
    @Size(min=1,max=20)
    private String data_co;
    @NotNull
    @Column(name="hora")
    @Size(min=1,max=20)
    private String hora;
    @NotNull
    @Column(name="descricao")
    @Size(min=1,max=20)
    private String descricao;
    @JoinColumn(name="id_contato",referencedColumnName="id_contato")
    @ManyToOne(optional=false)
    private Contato contato;

    public Compromisso() {
    }
    
    
    public Compromisso(int id_co, String data_co, String hora, String descricao, Contato contato) {
        this.id_co = id_co;
        this.data_co = data_co;
        this.hora = hora;
        this.descricao = descricao;
        this.contato = contato;
    }

    public int getId_co() {
        return id_co;
    }

    public void setId_co(int id_co) {
        this.id_co = id_co;
    }

    public String getData_co() {
        return data_co;
    }

    public void setData_co(String data_co) {
        this.data_co = data_co;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
