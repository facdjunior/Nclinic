package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class InformacaoAdicional extends GenericDomain {

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose
    private Pessoa pessoa;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose
    private TipoInformacaoAdicional tipoInformacaoAdicional;
    
    @Column(nullable = false)
    @Expose
    private Long Sequencia;
            
    @OneToOne
    @JoinColumn(nullable = false)
    @Expose
    private Empresa entidade;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;
    
    @Column(length = 80)
    @Expose
    private String Descricao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoInformacaoAdicional getTipoInformacaoAdicional() {
        return tipoInformacaoAdicional;
    }

    public void setTipoInformacaoAdicional(TipoInformacaoAdicional tipoInformacaoAdicional) {
        this.tipoInformacaoAdicional = tipoInformacaoAdicional;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
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
