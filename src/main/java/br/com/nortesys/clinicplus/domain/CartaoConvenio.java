package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @Expose
    private Long Sequencia;
    @EmbeddedId
    private EmpresaID empresaID;

    @Column(length = 90)
    @Expose
    private String TipoPlano;

    @Column(length = 90)
    @Expose
    private String Acomodacao;

    @Column(length = 30)
    @Expose
    private String NumeroCartaoConvenio;

    @Temporal(TemporalType.DATE)
    @Expose
    private Date DataVinculo;

    @Temporal(TemporalType.DATE)
    @Expose
    private Date DataValidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Expose
    private Date DataCadastro;

    @OneToOne
    @Expose
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    @Expose
    private Convenio convenio;

    @OneToOne(cascade = CascadeType.ALL)
    @Expose
    @JoinColumn(nullable = false)
    private TipoConvenio tipoConvenio;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Empresa entidade;

    public EmpresaID getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(EmpresaID empresaID) {
        this.empresaID = empresaID;
    }
    
    

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
