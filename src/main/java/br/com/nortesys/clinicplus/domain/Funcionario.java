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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {

    @Column(nullable = false)
    @SequenceGenerator(name = "Sequencia", initialValue = 1)
    private Integer Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    @Temporal(TemporalType.DATE)
    private Date DataAdmissao;

    @Temporal(TemporalType.DATE)
    private Date Demissao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    private String caminho;

    @OneToOne
    @JoinColumn(nullable = false)
    private TipoFuncionario tipoFuncionario;

    @OneToOne
    @JoinColumn(nullable = false)
    private Empresa entidade;

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
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

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public Date getDataAdmissao() {
        return DataAdmissao;
    }

    public void setDataAdmissao(Date DataAdmissao) {
        this.DataAdmissao = DataAdmissao;
    }

    public Date getDemissao() {
        return Demissao;
    }

    public void setDemissao(Date Demissao) {
        this.Demissao = Demissao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }

    public Funcionario() {

        pessoa = new Pessoa();

        this.pessoa.getContato().setPessoa(pessoa);
        this.pessoa.getDocumento().setPessoa(pessoa);
        this.pessoa.getEndereco().setPessoa(pessoa);
        this.pessoa.getInforAdicionais().setPessoa(pessoa);

    }

}
