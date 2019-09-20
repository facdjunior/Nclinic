package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Francisco Junior
 */
@Entity
@SuppressWarnings("serial")
public class Pessoa extends GenericDomain {

    @Column(length = 120, nullable = false)
    private String Nome;

    @Column(unique = true, nullable = true, columnDefinition = "serial")
    private Long Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(nullable = false)
    private Date DataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private PessoaFisica pessoaFisica;

    @Column(length = 120)
    private String imagem;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contato contato;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco endereco;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Documento documento;

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

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Pessoa() {

        this.documento = new Documento();
        this.contato = new Contato();
        this.endereco = new Endereco();
        this.pessoaFisica = new PessoaFisica();

        if (pessoaFisica.getSequencia() == null) {
            
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setSequencia(1);
        }

        if (documento.getSequencia() == null) {

            documento.setDataCadastro(new Date());
            documento.setSequencia(1);
        }

        if (endereco.getSequencia() == null) {

            endereco.setSequencia(1L);
            endereco.setDataCadastro(new Date());
        }

    }
}
