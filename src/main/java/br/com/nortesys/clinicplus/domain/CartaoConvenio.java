package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class CartaoConvenio extends GenericDomain {

    @Column(nullable = false)
    private Long Sequencia;

    @Column(length = 90)
    private String TipoPlano;

    @Column(length = 90)
    @Expose
    private String Acomodacao;

    @Column(length = 30)
    private String NumeroCartaoConvenio;

    @Temporal(TemporalType.DATE)
    private Date DataVinculo;

    @Temporal(TemporalType.DATE)
    private Date DataValidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private Convenio convenio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private TipoConvenio tipoConvenio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Empresa entidade;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public TipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public String getTipoPlano() {
        return TipoPlano;
    }

    public void setTipoPlano(String TipoPlano) {
        this.TipoPlano = TipoPlano;
    }

    public String getAcomodacao() {
        return Acomodacao;
    }

    public void setAcomodacao(String Acomodacao) {
        this.Acomodacao = Acomodacao;
    }

    public String getNumeroCartaoConvenio() {
        return NumeroCartaoConvenio;
    }

    public void setNumeroCartaoConvenio(String NumeroCartaoConvenio) {
        this.NumeroCartaoConvenio = NumeroCartaoConvenio;
    }

    public Date getDataVinculo() {
        return DataVinculo;
    }

    public void setDataVinculo(Date DataVinculo) {
        this.DataVinculo = DataVinculo;
    }

    public Date getDataValidade() {
        return DataValidade;
    }

    public void setDataValidade(Date DataValidade) {
        this.DataValidade = DataValidade;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public CartaoConvenio() {
        this.setPessoa(pessoa);
        convenio = new Convenio();
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
}
