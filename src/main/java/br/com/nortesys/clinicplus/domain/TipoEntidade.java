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
public class TipoEntidade extends GenericDomain{
    
    @Column(length = 250, nullable = false)
    private String Descricao;
    
    @Column(length = 80)
    private String ChaveMaster;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @Column(nullable = false)
    private Long Sequencia;
    
    private Long CodigoEntidade;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getChaveMaster() {
        return ChaveMaster;
    }

    public void setChaveMaster(String ChaveMaster) {
        this.ChaveMaster = ChaveMaster;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Long getCodigoEntidade() {
        return CodigoEntidade;
    }

    public void setCodigoEntidade(Long CodigoEntidade) {
        this.CodigoEntidade = CodigoEntidade;
    }
}
