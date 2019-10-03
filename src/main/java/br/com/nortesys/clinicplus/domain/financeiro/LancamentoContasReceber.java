package br.com.nortesys.clinicplus.domain.financeiro;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.GenericDomain;
import br.com.nortesys.clinicplus.domain.financeiro.TipoLancamentos;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class LancamentoContasReceber extends GenericDomain{
    
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Column(length = 190, nullable = false)
    private String Descricao;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private TipoLancamentos tipoLancamentos;
    
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal Valor;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    
    @Column(length = 200)
    private String Observacao;

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

    public TipoLancamentos getTipoLancamentos() {
        return tipoLancamentos;
    }

    public void setTipoLancamentos(TipoLancamentos tipoLancamentos) {
        this.tipoLancamentos = tipoLancamentos;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal Valor) {
        this.Valor = Valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }
    
    
    
}
