package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


/**
 *
 * @author Francisco Junior 2019-08-23
 */
@SuppressWarnings("serial")
@Entity
public class Contato extends GenericDomain {

    @Column(unique = false, nullable = false)
    private Long Sequencia;

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
    
    @ManyToOne
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.Sequencia);
        hash = 41 * hash + Objects.hashCode(this.Celular);
        hash = 41 * hash + Objects.hashCode(this.Celular1);
        hash = 41 * hash + Objects.hashCode(this.fone);
        hash = 41 * hash + Objects.hashCode(this.fone2);
        hash = 41 * hash + Objects.hashCode(this.DataCadastro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.Celular, other.Celular)) {
            return false;
        }
        if (!Objects.equals(this.Celular1, other.Celular1)) {
            return false;
        }
        if (!Objects.equals(this.fone, other.fone)) {
            return false;
        }
        if (!Objects.equals(this.fone2, other.fone2)) {
            return false;
        }
        if (!Objects.equals(this.Sequencia, other.Sequencia)) {
            return false;
        }
        if (!Objects.equals(this.DataCadastro, other.DataCadastro)) {
            return false;
        }
        return true;
    }

}
