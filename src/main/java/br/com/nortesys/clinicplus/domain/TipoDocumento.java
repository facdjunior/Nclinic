package br.com.nortesys.clinicplus.domain;

import java.util.Date;

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
 *
 */
@SuppressWarnings("serial")
@Entity
public class TipoDocumento extends GenericDomain {
    
    
    @Column(nullable = false)
    private Boolean PessoaFisica;

    @Column(nullable = false, length = 80)
    private String Descricao;

    private Boolean Ativo;

    @Column(unique = true, nullable = false)
    private Long Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    @Column(nullable = false, length = 80)
    private String TipoDado;
    
    @OneToOne
    @JoinColumn(nullable = false)
    @Embedded
    private Empresa entidade;

    public Boolean getPessoaFisica() {
        return PessoaFisica;
    }

    public void setPessoaFisica(Boolean PessoaFisica) {
        this.PessoaFisica = PessoaFisica;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
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

    public String getTipoDado() {
        return TipoDado;
    }

    public void setTipoDado(String TipoDado) {
        this.TipoDado = TipoDado;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
    
    
    
}
