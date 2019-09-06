package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Integer Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

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

}
