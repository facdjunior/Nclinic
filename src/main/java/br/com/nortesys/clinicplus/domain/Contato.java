package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Francisco Junior 2019-08-23
 */
@SuppressWarnings("serial")
@Entity
public class Contato extends GenericDomain {

    @Column(unique = false, nullable = false)
    private Long Sequencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @Column(length = 14)
    private String Celular;

    @Column(length = 14)
    private String Celular1;

    @Column(length = 13)
    private String fone;

    @Column(length = 13)
    private String fone2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCelular1() {
        return Celular1;
    }

    public void setCelular1(String Celular1) {
        this.Celular1 = Celular1;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

}
