package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@Entity
public class InforAdicionais extends GenericDomain {

    @Expose
    private Character Raça;

    @Expose
    private Character TipoSanguineo;

    @Expose
    private Character FatorRh;

    @Column(length = 30)
    @Expose
    private String NumeroCartaoSus;

    @Column(length = 8)
    @Expose
    private String CodigoANS;

    @Column(nullable = true, length = 120)
    @Expose(serialize = true)
    private String NomeMae;

    @Column(length = 120)
    @Expose(serialize = true)
    private String NomePai;

    @Column(length = 120)
    @Expose(serialize = true)
    private String Conjuge;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose
    private Pessoa pessoa;
    
    @Column(length = 190)
    @Expose
    private String LocalTrabalho;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @Expose
    private Convenio convenio;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
    
    

    public String getLocalTrabalho() {
        return LocalTrabalho;
    }

    public void setLocalTrabalho(String LocalTrabalho) {
        this.LocalTrabalho = LocalTrabalho;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Character getRaça() {
        return Raça;
    }

    public void setRaça(Character Raça) {
        this.Raça = Raça;
    }

    public Character getTipoSanguineo() {
        return TipoSanguineo;
    }

    public void setTipoSanguineo(Character TipoSanguineo) {
        this.TipoSanguineo = TipoSanguineo;
    }

    public Character getFatorRh() {
        return FatorRh;
    }

    public void setFatorRh(Character FatorRh) {
        this.FatorRh = FatorRh;
    }

    public String getNumeroCartaoSus() {
        return NumeroCartaoSus;
    }

    public void setNumeroCartaoSus(String NumeroCartaoSus) {
        this.NumeroCartaoSus = NumeroCartaoSus;
    }

    public String getCodigoANS() {
        return CodigoANS;
    }

    public void setCodigoANS(String CodigoANS) {
        this.CodigoANS = CodigoANS;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String NomeMae) {
        this.NomeMae = NomeMae;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String NomePai) {
        this.NomePai = NomePai;
    }

    public String getConjuge() {
        return Conjuge;
    }

    public void setConjuge(String Conjuge) {
        this.Conjuge = Conjuge;
    }
}
