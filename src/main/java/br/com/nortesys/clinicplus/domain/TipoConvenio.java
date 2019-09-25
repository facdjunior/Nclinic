package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class TipoConvenio extends GenericDomain {

    @OneToOne
    @JoinColumn(nullable = false)
    private Convenio convenio;

    @Column(nullable = false, length = 12)
    private Integer Sequencia;

    @Column(nullable = false, length = 90)
    private String Descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    private Boolean Ativo;

    private Boolean ELimitarAtendimentoPorDia;
    
    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

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

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }

    public Boolean getELimitarAtendimentoPorDia() {
        return ELimitarAtendimentoPorDia;
    }

    public void setELimitarAtendimentoPorDia(Boolean ELimitarAtendimentoPorDia) {
        this.ELimitarAtendimentoPorDia = ELimitarAtendimentoPorDia;
    }
    
}
