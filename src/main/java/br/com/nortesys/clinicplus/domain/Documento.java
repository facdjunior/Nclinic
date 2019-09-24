package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

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

    @Column(length = 14, nullable = false)
    @Expose
    private String Cpf;
    
    @Column(length = 20)
    @Expose
    private String Rg;
    
    @Column(length = 30)
    @Expose
    private String OrgaoEmissor;
    
    @Temporal(TemporalType.DATE)
    @Expose
    private Date DataEmissaoRg;
    
    @Column(length = 50)
    @Expose
    private String CertNascimento;
    
    @Column(length = 50)
    @Expose
    private String NumeroMatricula;
    
    @Column(length = 50)
    @Expose
    private String InscEstadual;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose(serialize = false)
    private Pessoa pessoa;

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getOrgaoEmissor() {
        return OrgaoEmissor;
    }

    public void setOrgaoEmissor(String OrgaoEmissor) {
        this.OrgaoEmissor = OrgaoEmissor;
    }

    public Date getDataEmissaoRg() {
        return DataEmissaoRg;
    }

    public void setDataEmissaoRg(Date DataEmissaoRg) {
        this.DataEmissaoRg = DataEmissaoRg;
    }
    
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
        return Cpf;
    }

    public void setDescricao(String Cpf) {
        this.Cpf = Cpf;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    
    public String getCertNascimento() {
        return CertNascimento;
    }

    public void setCertNascimento(String CertNascimento) {
        this.CertNascimento = CertNascimento;
    }

    public String getNumeroMatricula() {
        return NumeroMatricula;
    }

    public void setNumeroMatricula(String NumeroMatricula) {
        this.NumeroMatricula = NumeroMatricula;
    }

    public String getInscEstadual() {
        return InscEstadual;
    }

    public void setInscEstadual(String InscEstadual) {
        this.InscEstadual = InscEstadual;
    }
}
