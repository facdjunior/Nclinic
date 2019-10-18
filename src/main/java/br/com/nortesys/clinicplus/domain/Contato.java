package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior 2019-08-23
 */
@SuppressWarnings("serial")
@Entity
public class Contato extends GenericDomain {

   @Column(unique = false, nullable = false)
    @Expose
    private Long Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose(serialize = false)
    private Pessoa pessoa;
    
    @OneToOne
    @JoinColumn(nullable = true)
    @Embedded
    private Empresa entidade;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
    
    public Contato() {

        this.setPessoa(pessoa);
        this.setEntidade(entidade);
    }
}
