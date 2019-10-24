package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@Entity
@SuppressWarnings("serial")
public class Pessoa extends GenericDomain {

    @Column(length = 120, nullable = false)
    @Expose(serialize = true, deserialize = false)
    private String Nome;

    @Column(unique = true, nullable = true)
    @Expose
    private Long Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(nullable = false)
    @Expose
    private Date DataCadastro;
    @Expose
    private Boolean PessoaFisica;
    @Expose
    private String imagem;
    
    @Expose
    private Long CodigoImagem;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contato contato;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco endereco;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Documento documento;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private InformacaoAdicional inforAdicionais;

    @OneToOne(mappedBy = "pessoa")
    private CartaoConvenio cartaoConvenio;

    @OneToOne
    @JoinColumn(nullable = true)
    private Empresa entidade;

    public Long getCodigoImagem() {
        return CodigoImagem;
    }

    public void setCodigoImagem(Long CodigoImagem) {
        this.CodigoImagem = CodigoImagem;
    }
    
    public CartaoConvenio getCartaoConvenio() {
        return cartaoConvenio;
    }

    public void setCartaoConvenio(CartaoConvenio cartaoConvenio) {
        this.cartaoConvenio = cartaoConvenio;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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
        this.DataCadastro = new Date();
    }

    public Boolean getPessoaFisica() {
        return PessoaFisica;
    }

    public void setPessoaFisica(Boolean PessoaFisica) {
        this.PessoaFisica = PessoaFisica;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public InformacaoAdicional getInforAdicionais() {
        return inforAdicionais;
    }

    public void setInforAdicionais(InformacaoAdicional inforAdicionais) {
        this.inforAdicionais = inforAdicionais;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }

    public Pessoa() {

        this.documento = new Documento();
        this.contato = new Contato();
        this.endereco = new Endereco();
        this.inforAdicionais = new InformacaoAdicional();
        this.cartaoConvenio = new CartaoConvenio();
        this.entidade = new Empresa();

    }
}
