package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
public class TipoInformacaoAdicional extends GenericDomain{
    
    @Column(nullable = false, length = 80)
    private String Descricao;
    
    private Boolean Ativo;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Entidade entidade;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @Column(length = 50)
    private String TipoDadoColuna;
    
    private Boolean PessoaFisica;
    
    private Boolean CampoObrigatorio;
    
    @Column(length = 80)
    private String Mascara;
    
    @Column(length = 80)
    private String ProcedureValidacao;

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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getTipoDadoColuna() {
        return TipoDadoColuna;
    }

    public void setTipoDadoColuna(String TipoDadoColuna) {
        this.TipoDadoColuna = TipoDadoColuna;
    }

    public Boolean getPessoaFisica() {
        return PessoaFisica;
    }

    public void setPessoaFisica(Boolean PessoaFisica) {
        this.PessoaFisica = PessoaFisica;
    }

    public Boolean getCampoObrigatorio() {
        return CampoObrigatorio;
    }

    public void setCampoObrigatorio(Boolean CampoObrigatorio) {
        this.CampoObrigatorio = CampoObrigatorio;
    }

    public String getMascara() {
        return Mascara;
    }

    public void setMascara(String Mascara) {
        this.Mascara = Mascara;
    }

    public String getProcedureValidacao() {
        return ProcedureValidacao;
    }

    public void setProcedureValidacao(String ProcedureValidacao) {
        this.ProcedureValidacao = ProcedureValidacao;
    }
}
