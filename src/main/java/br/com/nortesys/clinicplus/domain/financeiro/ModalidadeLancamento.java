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
public class ModalidadeLancamento extends GenericDomain{
    
    @Column(nullable = false)
    private Integer Sequencia;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @Column(length = 90, nullable = false)
    private String Descricao;

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    
}
