package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
public class TipoContato extends GenericDomain{
    
    @Column(length = 80, nullable = false)
    private String Descricao;
    
    @Column(nullable = false)
    private Long Sequencia;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    @Column(length = 80)
    private String TipoDado;
    
    private boolean CampoObrigatorio;
    @Column(length = 80)
    private String Mascara;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Empresa entidade;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
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

    public String getTipoDado() {
        return TipoDado;
    }

    public void setTipoDado(String TipoDado) {
        this.TipoDado = TipoDado;
    }

    public boolean isCampoObrigatorio() {
        return CampoObrigatorio;
    }

    public void setCampoObrigatorio(boolean CampoObrigatorio) {
        this.CampoObrigatorio = CampoObrigatorio;
    }

    public String getMascara() {
        return Mascara;
    }

    public void setMascara(String Mascara) {
        this.Mascara = Mascara;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }
    
    
}
