package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Cidade extends GenericDomain{
    
    
    private Long Sequencia;
    
    @Column(length = 90)
    private String Descricao;
    
    private Integer CodigoIBGE;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private UF uf;
    
    private Boolean Ativo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
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

    public Integer getCodigoIBGE() {
        return CodigoIBGE;
    }

    public void setCodigoIBGE(Integer CodigoIBGE) {
        this.CodigoIBGE = CodigoIBGE;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
}
