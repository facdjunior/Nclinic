package br.com.nortesys.clinicplus.domain;

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
public class UF extends GenericDomain{
    
    @Column(length = 90, nullable = false)
    private String Descricao;
    
    @Column(length = 2)
    private String UF;
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    
    @Column(length = 2)
    private String CodigoTISS_UF;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
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

    public String getCodigoTISS_UF() {
        return CodigoTISS_UF;
    }

    public void setCodigoTISS_UF(String CodigoTISS_UF) {
        this.CodigoTISS_UF = CodigoTISS_UF;
    }
}
