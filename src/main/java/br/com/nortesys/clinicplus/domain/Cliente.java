package br.com.nortesys.clinicplus.domain;

import br.com.nortesys.clinicplus.dao.PessoaDAO;
import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {

    @Column(nullable = false)
    @SequenceGenerator(name = "Sequencia", initialValue = 1)
    @Expose(serialize = true)
    private Integer Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose(serialize = true)
    private Date DataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose(serialize = true)
    private Pessoa pessoa;
    
    @Column(length = 200)
    @Expose(serialize = true)
    private String Observacao;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Entidade entidade;
    
    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }
    
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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    public Cliente() {
        this.pessoa = new Pessoa();

  
        this.pessoa.getContato().setPessoa(pessoa);
        this.pessoa.getDocumento().setPessoa(pessoa);
        this.pessoa.getEndereco().setPessoa(pessoa);
        this.pessoa.getInforAdicionais().setPessoa(pessoa);
        this.pessoa.getCartaoConvenio().setPessoa(pessoa);
        

    }

}
