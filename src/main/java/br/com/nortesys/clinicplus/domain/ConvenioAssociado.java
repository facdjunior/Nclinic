package br.com.nortesys.clinicplus.domain;

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
 * @author Francisco Junior
 */

@SuppressWarnings("serial")
@Entity
public class ConvenioAssociado extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Column(length = 190, nullable = false)
    private String Descricao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    private boolean ECortesia;
    
    @OneToOne
    @JoinColumn(nullable = false)
    @Embedded
    private Empresa entidade;

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public boolean isECortesia() {
        return ECortesia;
    }

    public void setECortesia(boolean ECortesia) {
        this.ECortesia = ECortesia;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
    
}
