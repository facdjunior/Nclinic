package br.com.nortesys.clinicplus.domain;


import com.google.gson.annotations.Expose;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Documento extends GenericDomain {

    @Column(unique = true, nullable = false)
    @Expose
    private Integer Sequencia;

    @Column(length = 120, nullable = false)
    @Expose
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    

}
