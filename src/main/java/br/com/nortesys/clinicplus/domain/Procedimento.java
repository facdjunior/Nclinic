package br.com.nortesys.clinicplus.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Procedimento extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Convenio convenio;
    
    @Column(nullable = false, length = 12)
    private String CodigoANS;
    
    @Column(nullable = false, length = 190)
    private String Procedimento;
    
    private Boolean ESessao;
    
    private Boolean EProdutoKit;
    @Column(length = 12)
    private String CodigoProcedimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataAtualizacao;

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
    
    public String getCodigoANS() {
        return CodigoANS;
    }

    public void setCodigoANS(String CodigoANS) {
        this.CodigoANS = CodigoANS;
    }

    public String getProcedimento() {
        return Procedimento;
    }

    public void setProcedimento(String Procedimento) {
        this.Procedimento = Procedimento;
    }

    public Boolean getESessao() {
        return ESessao;
    }

    public void setESessao(Boolean ESessao) {
        this.ESessao = ESessao;
    }

    public Boolean getEProdutoKit() {
        return EProdutoKit;
    }

    public void setEProdutoKit(Boolean EProdutoKit) {
        this.EProdutoKit = EProdutoKit;
    }

    public String getCodigoProcedimento() {
        return CodigoProcedimento;
    }

    public void setCodigoProcedimento(String CodigoProcedimento) {
        this.CodigoProcedimento = CodigoProcedimento;
    }

    public Date getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(Date DataAtualizacao) {
        this.DataAtualizacao = DataAtualizacao;
    }
    
}
