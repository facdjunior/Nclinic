package br.com.nortesys.clinicplus.domain;

import br.com.nortesys.clinicplus.dao.PessoaDAO;
import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
    private Pessoa pessoa = new Pessoa();

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

    public Cliente() {
        this.pessoa = new Pessoa();

        this.setPessoa(pessoa);
        this.pessoa.getContato().setPessoa(pessoa);
        this.pessoa.getDocumento().setPessoa(pessoa);
        this.pessoa.getEndereco().setPessoa(pessoa);

    }

}
