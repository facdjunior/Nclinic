package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity

public class Empresa extends GenericDomain {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @Expose
    private Pessoa pessoa;

    @Column(length = 80)
    @Expose
    private String ChaveMaster;

    @OneToOne(cascade = CascadeType.ALL)
    @Expose
    private TipoEntidade tipoEntidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;
    @Expose
    private Long CodigoImagemLogoTipo;
    @Expose
    private Long Sequencia;
    @Expose
    private Long CodigoCNES;
    @Expose
    private Boolean EOptanteSimplesNacional;
    @Expose
    private Long InscricaoMunicipal;
    @Expose
    private Long InscricaoEstadual;
    @Expose
    private Boolean PossuiIncentivoFiscal;
    @Expose
    private Long CodigoRegimeEspecialTributacao;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal AliquotaSimples;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal ISSRetido;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal PISS;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal COFINS;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal IRRF;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal CSLL;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal INSS;
    @Expose
    private Boolean EmitirNFSe;
    @Expose
    private Long NumeroRPSInicial;
    @Expose
    private Long NumeroLoteInicial;

    @Column(length = 9)
    @Expose
    private String CodigoTributarioMunicipal;
    @Expose
    private Boolean PossuiISSRetido;
    @Expose
    private Long CodigoExigibilidadeISS;

    @Column(precision = 4, scale = 2)
    @Expose
    private BigDecimal AliquotaISS;
    @Expose
    private String Certificado;
    @Expose
    private Boolean EAmbienteProducao;
    @Expose
    private Boolean ECritptografadoSLL;
    @Expose
    private Boolean EEnviarEmailAposEmissao;
    @Expose
    private Boolean HabilitarHorarioDeVerao;
    @Expose
    private Boolean UsandoHorarioDeVerao;
    @Expose
    private Long CodigoRelatorioDANFE;
    @Expose
    private Long CodigoRelatorioPadrao;
    @Expose
    private Long QuantidadeCopiasDANFE;
    @Expose
    private Long EReiniciarServicos;
    @Expose
    private Boolean UploadNuvem;
    @Expose
    private Boolean ImprimirAposEmissao;

    @Temporal(TemporalType.TIMESTAMP)
    @Expose
    private Date DataUltimaSincronizacao;

    @Column(length = 250)
    @Expose
    private String JustificativaEntradaContigencia;

    @Column(length = 350)
    @Expose
    private String TokenNFSe;
    @Expose
    private Boolean EEnviarEmailDestinatario;
    @Expose
    private Long PortaServidor;

    @Column(length = 250)
    @Expose
    private String OutrosEmails;

    @Column(length = 50)
    @Expose
    private String SenhaEmail;

    @Column(length = 100)
    @Expose
    private String ServidorSMTP;

    @Column(length = 50)
    @Expose
    private String AssuntoEmail;

    @Column(length = 250)
    @Expose
    private String ConteudoCorpoEmail;

    @Column(length = 150)
    @Expose
    private String InformacaoImpressoraPadrao;
    @Expose
    private Boolean EInicializarServicontcomWindows;
    @Expose
    private Boolean EServicontPrincipal;
    @Expose
    private Boolean EEmitirSemCertificado;

    @Column(length = 50)
    @Expose
    private String CodigoServico;
    @Expose
    private Long CodigoLocalPrestacaoServico;
    @Expose
    private Long CodigoIncentivadorCultural;
    @Expose
    private Long CodigoStatusRPS;
    @Expose
    private Long CodigoRecolhimentoImposto;
    @Expose
    private Long CodigoFormaTributacaoISS;
    @Expose
    private Long CodigoServicoViasPublicas;

    @Column(length = 150)
    @Expose
    private String ChaveAcesso;

    @Column(length = 150)
    @Expose
    private String ChaveParceiro;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getChaveMaster() {
        return ChaveMaster;
    }

    public void setChaveMaster(String ChaveMaster) {
        this.ChaveMaster = ChaveMaster;
    }

    public TipoEntidade getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(TipoEntidade tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Long getCodigoImagemLogoTipo() {
        return CodigoImagemLogoTipo;
    }

    public void setCodigoImagemLogoTipo(Long CodigoImagemLogoTipo) {
        this.CodigoImagemLogoTipo = CodigoImagemLogoTipo;
    }

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Long getCodigoCNES() {
        return CodigoCNES;
    }

    public void setCodigoCNES(Long CodigoCNES) {
        this.CodigoCNES = CodigoCNES;
    }

    public Boolean getEOptanteSimplesNacional() {
        return EOptanteSimplesNacional;
    }

    public void setEOptanteSimplesNacional(Boolean EOptanteSimplesNacional) {
        this.EOptanteSimplesNacional = EOptanteSimplesNacional;
    }

    public Long getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }

    public void setInscricaoMunicipal(Long InscricaoMunicipal) {
        this.InscricaoMunicipal = InscricaoMunicipal;
    }

    public Long getInscricaoEstadual() {
        return InscricaoEstadual;
    }

    public void setInscricaoEstadual(Long InscricaoEstadual) {
        this.InscricaoEstadual = InscricaoEstadual;
    }

    public Boolean getPossuiIncentivoFiscal() {
        return PossuiIncentivoFiscal;
    }

    public void setPossuiIncentivoFiscal(Boolean PossuiIncentivoFiscal) {
        this.PossuiIncentivoFiscal = PossuiIncentivoFiscal;
    }

    public Long getCodigoRegimeEspecialTributacao() {
        return CodigoRegimeEspecialTributacao;
    }

    public void setCodigoRegimeEspecialTributacao(Long CodigoRegimeEspecialTributacao) {
        this.CodigoRegimeEspecialTributacao = CodigoRegimeEspecialTributacao;
    }

    public BigDecimal getAliquotaSimples() {
        return AliquotaSimples;
    }

    public void setAliquotaSimples(BigDecimal AliquotaSimples) {
        this.AliquotaSimples = AliquotaSimples;
    }

    public BigDecimal getISSRetido() {
        return ISSRetido;
    }

    public void setISSRetido(BigDecimal ISSRetido) {
        this.ISSRetido = ISSRetido;
    }

    public BigDecimal getPISS() {
        return PISS;
    }

    public void setPISS(BigDecimal PISS) {
        this.PISS = PISS;
    }

    public BigDecimal getCOFINS() {
        return COFINS;
    }

    public void setCOFINS(BigDecimal COFINS) {
        this.COFINS = COFINS;
    }

    public BigDecimal getIRRF() {
        return IRRF;
    }

    public void setIRRF(BigDecimal IRRF) {
        this.IRRF = IRRF;
    }

    public BigDecimal getCSLL() {
        return CSLL;
    }

    public void setCSLL(BigDecimal CSLL) {
        this.CSLL = CSLL;
    }

    public BigDecimal getINSS() {
        return INSS;
    }

    public void setINSS(BigDecimal INSS) {
        this.INSS = INSS;
    }

    public Boolean getEmitirNFSe() {
        return EmitirNFSe;
    }

    public void setEmitirNFSe(Boolean EmitirNFSe) {
        this.EmitirNFSe = EmitirNFSe;
    }

    public Long getNumeroRPSInicial() {
        return NumeroRPSInicial;
    }

    public void setNumeroRPSInicial(Long NumeroRPSInicial) {
        this.NumeroRPSInicial = NumeroRPSInicial;
    }

    public Long getNumeroLoteInicial() {
        return NumeroLoteInicial;
    }

    public void setNumeroLoteInicial(Long NumeroLoteInicial) {
        this.NumeroLoteInicial = NumeroLoteInicial;
    }

    public String getCodigoTributarioMunicipal() {
        return CodigoTributarioMunicipal;
    }

    public void setCodigoTributarioMunicipal(String CodigoTributarioMunicipal) {
        this.CodigoTributarioMunicipal = CodigoTributarioMunicipal;
    }

    public Boolean getPossuiISSRetido() {
        return PossuiISSRetido;
    }

    public void setPossuiISSRetido(Boolean PossuiISSRetido) {
        this.PossuiISSRetido = PossuiISSRetido;
    }

    public Long getCodigoExigibilidadeISS() {
        return CodigoExigibilidadeISS;
    }

    public void setCodigoExigibilidadeISS(Long CodigoExigibilidadeISS) {
        this.CodigoExigibilidadeISS = CodigoExigibilidadeISS;
    }

    public BigDecimal getAliquotaISS() {
        return AliquotaISS;
    }

    public void setAliquotaISS(BigDecimal AliquotaISS) {
        this.AliquotaISS = AliquotaISS;
    }

    public String getCertificado() {
        return Certificado;
    }

    public void setCertificado(String Certificado) {
        this.Certificado = Certificado;
    }

    public Boolean getEAmbienteProducao() {
        return EAmbienteProducao;
    }

    public void setEAmbienteProducao(Boolean EAmbienteProducao) {
        this.EAmbienteProducao = EAmbienteProducao;
    }

    public Boolean getECritptografadoSLL() {
        return ECritptografadoSLL;
    }

    public void setECritptografadoSLL(Boolean ECritptografadoSLL) {
        this.ECritptografadoSLL = ECritptografadoSLL;
    }

    public Boolean getEEnviarEmailAposEmissao() {
        return EEnviarEmailAposEmissao;
    }

    public void setEEnviarEmailAposEmissao(Boolean EEnviarEmailAposEmissao) {
        this.EEnviarEmailAposEmissao = EEnviarEmailAposEmissao;
    }

    public Boolean getHabilitarHorarioDeVerao() {
        return HabilitarHorarioDeVerao;
    }

    public void setHabilitarHorarioDeVerao(Boolean HabilitarHorarioDeVerao) {
        this.HabilitarHorarioDeVerao = HabilitarHorarioDeVerao;
    }

    public Boolean getUsandoHorarioDeVerao() {
        return UsandoHorarioDeVerao;
    }

    public void setUsandoHorarioDeVerao(Boolean UsandoHorarioDeVerao) {
        this.UsandoHorarioDeVerao = UsandoHorarioDeVerao;
    }

    public Long getCodigoRelatorioDANFE() {
        return CodigoRelatorioDANFE;
    }

    public void setCodigoRelatorioDANFE(Long CodigoRelatorioDANFE) {
        this.CodigoRelatorioDANFE = CodigoRelatorioDANFE;
    }

    public Long getCodigoRelatorioPadrao() {
        return CodigoRelatorioPadrao;
    }

    public void setCodigoRelatorioPadrao(Long CodigoRelatorioPadrao) {
        this.CodigoRelatorioPadrao = CodigoRelatorioPadrao;
    }

    public Long getQuantidadeCopiasDANFE() {
        return QuantidadeCopiasDANFE;
    }

    public void setQuantidadeCopiasDANFE(Long QuantidadeCopiasDANFE) {
        this.QuantidadeCopiasDANFE = QuantidadeCopiasDANFE;
    }

    public Long getEReiniciarServicos() {
        return EReiniciarServicos;
    }

    public void setEReiniciarServicos(Long EReiniciarServicos) {
        this.EReiniciarServicos = EReiniciarServicos;
    }

    public Boolean getUploadNuvem() {
        return UploadNuvem;
    }

    public void setUploadNuvem(Boolean UploadNuvem) {
        this.UploadNuvem = UploadNuvem;
    }

    public Boolean getImprimirAposEmissao() {
        return ImprimirAposEmissao;
    }

    public void setImprimirAposEmissao(Boolean ImprimirAposEmissao) {
        this.ImprimirAposEmissao = ImprimirAposEmissao;
    }

    public Date getDataUltimaSincronizacao() {
        return DataUltimaSincronizacao;
    }

    public void setDataUltimaSincronizacao(Date DataUltimaSincronizacao) {
        this.DataUltimaSincronizacao = DataUltimaSincronizacao;
    }

    public String getJustificativaEntradaContigencia() {
        return JustificativaEntradaContigencia;
    }

    public void setJustificativaEntradaContigencia(String JustificativaEntradaContigencia) {
        this.JustificativaEntradaContigencia = JustificativaEntradaContigencia;
    }

    public String getTokenNFSe() {
        return TokenNFSe;
    }

    public void setTokenNFSe(String TokenNFSe) {
        this.TokenNFSe = TokenNFSe;
    }

    public Boolean getEEnviarEmailDestinatario() {
        return EEnviarEmailDestinatario;
    }

    public void setEEnviarEmailDestinatario(Boolean EEnviarEmailDestinatario) {
        this.EEnviarEmailDestinatario = EEnviarEmailDestinatario;
    }

    public Long getPortaServidor() {
        return PortaServidor;
    }

    public void setPortaServidor(Long PortaServidor) {
        this.PortaServidor = PortaServidor;
    }

    public String getOutrosEmails() {
        return OutrosEmails;
    }

    public void setOutrosEmails(String OutrosEmails) {
        this.OutrosEmails = OutrosEmails;
    }

    public String getSenhaEmail() {
        return SenhaEmail;
    }

    public void setSenhaEmail(String SenhaEmail) {
        this.SenhaEmail = SenhaEmail;
    }

    public String getServidorSMTP() {
        return ServidorSMTP;
    }

    public void setServidorSMTP(String ServidorSMTP) {
        this.ServidorSMTP = ServidorSMTP;
    }

    public String getAssuntoEmail() {
        return AssuntoEmail;
    }

    public void setAssuntoEmail(String AssuntoEmail) {
        this.AssuntoEmail = AssuntoEmail;
    }

    public String getConteudoCorpoEmail() {
        return ConteudoCorpoEmail;
    }

    public void setConteudoCorpoEmail(String ConteudoCorpoEmail) {
        this.ConteudoCorpoEmail = ConteudoCorpoEmail;
    }

    public String getInformacaoImpressoraPadrao() {
        return InformacaoImpressoraPadrao;
    }

    public void setInformacaoImpressoraPadrao(String InformacaoImpressoraPadrao) {
        this.InformacaoImpressoraPadrao = InformacaoImpressoraPadrao;
    }

    public Boolean getEInicializarServicontcomWindows() {
        return EInicializarServicontcomWindows;
    }

    public void setEInicializarServicontcomWindows(Boolean EInicializarServicontcomWindows) {
        this.EInicializarServicontcomWindows = EInicializarServicontcomWindows;
    }

    public Boolean getEServicontPrincipal() {
        return EServicontPrincipal;
    }

    public void setEServicontPrincipal(Boolean EServicontPrincipal) {
        this.EServicontPrincipal = EServicontPrincipal;
    }

    public Boolean getEEmitirSemCertificado() {
        return EEmitirSemCertificado;
    }

    public void setEEmitirSemCertificado(Boolean EEmitirSemCertificado) {
        this.EEmitirSemCertificado = EEmitirSemCertificado;
    }

    public String getCodigoServico() {
        return CodigoServico;
    }

    public void setCodigoServico(String CodigoServico) {
        this.CodigoServico = CodigoServico;
    }

    public Long getCodigoLocalPrestacaoServico() {
        return CodigoLocalPrestacaoServico;
    }

    public void setCodigoLocalPrestacaoServico(Long CodigoLocalPrestacaoServico) {
        this.CodigoLocalPrestacaoServico = CodigoLocalPrestacaoServico;
    }

    public Long getCodigoIncentivadorCultural() {
        return CodigoIncentivadorCultural;
    }

    public void setCodigoIncentivadorCultural(Long CodigoIncentivadorCultural) {
        this.CodigoIncentivadorCultural = CodigoIncentivadorCultural;
    }

    public Long getCodigoStatusRPS() {
        return CodigoStatusRPS;
    }

    public void setCodigoStatusRPS(Long CodigoStatusRPS) {
        this.CodigoStatusRPS = CodigoStatusRPS;
    }

    public Long getCodigoRecolhimentoImposto() {
        return CodigoRecolhimentoImposto;
    }

    public void setCodigoRecolhimentoImposto(Long CodigoRecolhimentoImposto) {
        this.CodigoRecolhimentoImposto = CodigoRecolhimentoImposto;
    }

    public Long getCodigoFormaTributacaoISS() {
        return CodigoFormaTributacaoISS;
    }

    public void setCodigoFormaTributacaoISS(Long CodigoFormaTributacaoISS) {
        this.CodigoFormaTributacaoISS = CodigoFormaTributacaoISS;
    }

    public Long getCodigoServicoViasPublicas() {
        return CodigoServicoViasPublicas;
    }

    public void setCodigoServicoViasPublicas(Long CodigoServicoViasPublicas) {
        this.CodigoServicoViasPublicas = CodigoServicoViasPublicas;
    }

    public String getChaveAcesso() {
        return ChaveAcesso;
    }

    public void setChaveAcesso(String ChaveAcesso) {
        this.ChaveAcesso = ChaveAcesso;
    }

    public String getChaveParceiro() {
        return ChaveParceiro;
    }

    public void setChaveParceiro(String ChaveParceiro) {
        this.ChaveParceiro = ChaveParceiro;
    }

    public Empresa() {

    }
}
