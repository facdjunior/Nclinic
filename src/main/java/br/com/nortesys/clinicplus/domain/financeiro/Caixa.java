package br.com.nortesys.clinicplus.domain.financeiro;

import br.com.nortesys.clinicplus.domain.GenericDomain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Caixa extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @Column(length = 3, nullable = false)
    private String NumeroCaixa;
    
    @Column(length = 60, nullable = false)
    private String Descricao;
    
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

    public String getNumeroCaixa() {
        return NumeroCaixa;
    }

    public void setNumeroCaixa(String NumeroCaixa) {
        this.NumeroCaixa = NumeroCaixa;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }
}
