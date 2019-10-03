package br.com.nortesys.clinicplus.domain.financeiro;

import br.com.nortesys.clinicplus.domain.GenericDomain;
import java.math.BigDecimal;
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
public class CaixaAberturaFechamento extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Caixa caixa;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataFechamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date Abertura;
    
    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal SaldoAbertura;
    
    @Column(precision = 7, scale = 2)
    private BigDecimal TotalEmCaixa;
    
    @Column(precision = 7, scale = 2)
    private BigDecimal ValorDiferença;
    
    @Column(length = 200)
    private String Justificativa;
    
    @Column(nullable = false)
    private Boolean Ativo;

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

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Date getDataFechamento() {
        return DataFechamento;
    }

    public void setDataFechamento(Date DataFechamento) {
        this.DataFechamento = DataFechamento;
    }

    public Date getAbertura() {
        return Abertura;
    }

    public void setAbertura(Date Abertura) {
        this.Abertura = Abertura;
    }

    public BigDecimal getSaldoAbertura() {
        return SaldoAbertura;
    }

    public void setSaldoAbertura(BigDecimal SaldoAbertura) {
        this.SaldoAbertura = SaldoAbertura;
    }

    public BigDecimal getTotalEmCaixa() {
        return TotalEmCaixa;
    }

    public void setTotalEmCaixa(BigDecimal TotalEmCaixa) {
        this.TotalEmCaixa = TotalEmCaixa;
    }

    public BigDecimal getValorDiferença() {
        return ValorDiferença;
    }

    public void setValorDiferença(BigDecimal ValorDiferença) {
        this.ValorDiferença = ValorDiferença;
    }

    public String getJustificativa() {
        return Justificativa;
    }

    public void setJustificativa(String Justificativa) {
        this.Justificativa = Justificativa;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }
    
    
}
