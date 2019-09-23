package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;


import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

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

    public Documento() {

        this.setPessoa(pessoa);
    }
}
