package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Francisco
 */
public class InformacoesAdicionais extends GenericDomain {

    @Column(length = 2)
    @Expose
    private Character Raça;
    @Column(length = 2)
    @Expose
    private Character TipoSanguineo;
    @Column(length = 2)
    @Expose
    private Character FatorRh;

    @Column(length = 30)
    @Expose
    private String NumeroCartaoSus;

    @Column(length = 8)
    @Expose
    private String CodigoANS;

    @OneToOne(cascade = CascadeType.ALL)
    @Expose
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

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
}
