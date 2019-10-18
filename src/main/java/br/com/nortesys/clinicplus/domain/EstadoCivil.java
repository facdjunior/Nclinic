package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class EstadoCivil extends GenericDomain {

    @Column(length = 80, nullable = false)
    @Expose(serialize = true)
    private String Descricao;
    
    @Expose(serialize = true)
    private Integer Sequencia;
    
    @OneToOne
    @JoinColumn(nullable = false)
    @Embedded
    private Empresa entidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose(serialize = true)
    private Date DataCadastro;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
    
    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public void setEntidade(Long entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
