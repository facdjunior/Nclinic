package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Procedimento extends GenericDomain {

    @Column(nullable = false)
    private Long Sequencia;

    @Column(length = 190, nullable = false)
    private String Descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;

    private boolean ESessao;

    private boolean Ativo;

    private boolean EProdutoKit;

    @Column(length = 12)
    private String NumeracaoProcedimento;

    @Column(length = 12)
    private String NumeracaoTuss;

    @Temporal(TemporalType.TIMESTAMP)
    private Date DataAtualizacao;

    private boolean EExame;

    @Column(length = 190)
    private String MensagemSMS;

    @Column(length = 250)
    private String MensagemEmail;

    private Long QuantidadeDiasEnviarMensagemMarketing;

    private boolean ELaudo;

    private boolean EAtestado;

    @OneToOne
    @JoinColumn(nullable = false)
    private Empresa entidade;

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

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public boolean isESessao() {
        return ESessao;
    }

    public void setESessao(boolean ESessao) {
        this.ESessao = ESessao;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }

    public boolean isEProdutoKit() {
        return EProdutoKit;
    }

    public void setEProdutoKit(boolean EProdutoKit) {
        this.EProdutoKit = EProdutoKit;
    }

    public String getNumeracaoProcedimento() {
        return NumeracaoProcedimento;
    }

    public void setNumeracaoProcedimento(String NumeracaoProcedimento) {
        this.NumeracaoProcedimento = NumeracaoProcedimento;
    }

    public String getNumeracaoTuss() {
        return NumeracaoTuss;
    }

    public void setNumeracaoTuss(String NumeracaoTuss) {
        this.NumeracaoTuss = NumeracaoTuss;
    }

    public Date getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(Date DataAtualizacao) {
        this.DataAtualizacao = DataAtualizacao;
    }

    public boolean isEExame() {
        return EExame;
    }

    public void setEExame(boolean EExame) {
        this.EExame = EExame;
    }

    public String getMensagemSMS() {
        return MensagemSMS;
    }

    public void setMensagemSMS(String MensagemSMS) {
        this.MensagemSMS = MensagemSMS;
    }

    public String getMensagemEmail() {
        return MensagemEmail;
    }

    public void setMensagemEmail(String MensagemEmail) {
        this.MensagemEmail = MensagemEmail;
    }

    public Long getQuantidadeDiasEnviarMensagemMarketing() {
        return QuantidadeDiasEnviarMensagemMarketing;
    }

    public void setQuantidadeDiasEnviarMensagemMarketing(Long QuantidadeDiasEnviarMensagemMarketing) {
        this.QuantidadeDiasEnviarMensagemMarketing = QuantidadeDiasEnviarMensagemMarketing;
    }

    public boolean isELaudo() {
        return ELaudo;
    }

    public void setELaudo(boolean ELaudo) {
        this.ELaudo = ELaudo;
    }

    public boolean isEAtestado() {
        return EAtestado;
    }

    public void setEAtestado(boolean EAtestado) {
        this.EAtestado = EAtestado;
    }

    public Empresa getEntidade() {
        return entidade;
    }

    public void setEntidade(Empresa entidade) {
        this.entidade = entidade;
    }

}
