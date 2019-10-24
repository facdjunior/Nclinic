package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Endereco extends GenericDomain {

    @Column(nullable = false)
    private Long Sequencia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Bairro bairro;

    private Boolean Ativo;

    @SerializedName("Descricao")
    private String logradouro;

    @SerializedName("cep")
    private String cep;

    @Column(length = 120)
    private String PontoReferencia;

    @Column(length = 160)
    private String LinkEndereco;

    private Boolean Principal;

    @OneToOne
    @JoinColumn(nullable = false)
    private TipoEndereco tipoEndereco;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    @Column(length = 200)
    private String Observacao;

    @SerializedName("numero")

    private String numero;

    private String complemento;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return PontoReferencia;
    }

    public void setPontoReferencia(String PontoReferencia) {
        this.PontoReferencia = PontoReferencia;
    }

    public String getLinkEndereco() {
        return LinkEndereco;
    }

    public void setLinkEndereco(String LinkEndereco) {
        this.LinkEndereco = LinkEndereco;
    }

    public Boolean getPrincipal() {
        return Principal;
    }

    public void setPrincipal(Boolean Principal) {
        this.Principal = Principal;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
