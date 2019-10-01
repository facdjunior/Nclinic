package br.com.nortesys.clinicplus.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    
    @OneToOne
    @JoinColumn(nullable = false)
    private ListaProcedimento listaProcedimento;
    
    private Boolean ESessao;
    
    private Boolean EProdutoKit;
    
    @Column(length = 12)
    private String CodigoProcedimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataAtualizacao;
    
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal ValorProcedimento;

    public BigDecimal getValorProcedimento() {
        return ValorProcedimento;
    }

    public void setValorProcedimento(BigDecimal ValorProcedimento) {
        this.ValorProcedimento = ValorProcedimento;
    }
    
    public ListaProcedimento getListaProcedimento() {
        return listaProcedimento;
    }

    public void setListaProcedimento(ListaProcedimento listaProcedimento) {
        this.listaProcedimento = listaProcedimento;
    }
    
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
