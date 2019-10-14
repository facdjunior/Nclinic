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
public class RelProcedimentoConvenioAssociado extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private ConvenioAssociado convenioAssociado;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Procedimento procedimento;
    
    private Boolean EParticular;
    
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal Valor;

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

    public ConvenioAssociado getConvenioAssociado() {
        return convenioAssociado;
    }

    public void setConvenioAssociado(ConvenioAssociado convenioAssociado) {
        this.convenioAssociado = convenioAssociado;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Boolean getEParticular() {
        return EParticular;
    }

    public void setEParticular(Boolean EParticular) {
        this.EParticular = EParticular;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal Valor) {
        this.Valor = Valor;
    }
}
