package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 *
 */
@SuppressWarnings("serial")
@Entity
public class Convenio extends GenericDomain {

    @Column(unique = true, nullable = false)
    private Integer Sequencia;

    @Column(length = 90, nullable = false)
    private String Descricao;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    
    

}
