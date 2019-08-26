package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class Profissao extends GenericDomain {

    @Column(unique = true, nullable = true)
    @SequenceGenerator(name = "Sequencia", initialValue = 1)
    private Long Sequencia;
    
    @Column(length = 120, nullable = false)
    private String Descricao;
    
    @Column(length = 20, nullable = false)
    private String CBO;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    
    @Column(length = 80)
    private String ConselhoProfissional;

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

    public String getCBO() {
        return CBO;
    }

    public void setCBO(String CBO) {
        this.CBO = CBO;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getConselhoProfissional() {
        return ConselhoProfissional;
    }

    public void setConselhoProfissional(String ConselhoProfissional) {
        this.ConselhoProfissional = ConselhoProfissional;
    }
    
    

}
