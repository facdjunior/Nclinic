package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior 2019-08-23
 */
@SuppressWarnings("serial")
@Entity
public class Contato extends GenericDomain {

    @Column(unique = false, nullable = false)
    @Expose
    private Long Sequencia;

    @Column(length = 14)
    @Expose
    private String Celular;

    @Column(length = 14)
    @Expose
    private String Celular1;

    @Column(length = 13)
    @Expose
    private String fone;

    @Column(length = 13)
    @Expose
    private String fone2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;

    @OneToOne
    @JoinColumn(nullable = false)

    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
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

    public Contato() {

        if (this.getSequencia() == null) {
            this.setDataCadastro(new Date());
            this.setPessoa(pessoa);
            this.setSequencia(1L);
        } else {
            this.setDataCadastro(new Date());
            this.setPessoa(pessoa);
            this.setSequencia(this.getSequencia() + 1);

        }
    }
}
