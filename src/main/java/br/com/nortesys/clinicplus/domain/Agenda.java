package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Agenda extends GenericDomain{
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date DataAtendimentoInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataChamado;
    
    @Temporal(TemporalType.DATE)
    private Date DataAtendimentoFim;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcionario funcionario;
    
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Convenio convenio;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private TipoAtendimento tipoAtendimento;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private ListaProcedimento listaProcedimento;
    
    
    @Column(length = 90)
    private String Nome;

    public ListaProcedimento getListaProcedimento() {
        return listaProcedimento;
    }

    public void setListaProcedimento(ListaProcedimento listaProcedimento) {
        this.listaProcedimento = listaProcedimento;
    }
    
    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataAtendimentoInicio() {
        return DataAtendimentoInicio;
    }

    public void setDataAtendimentoInicio(Date DataAtendimentoInicio) {
        this.DataAtendimentoInicio = DataAtendimentoInicio;
    }

    public Date getDataChamado() {
        return DataChamado;
    }

    public void setDataChamado(Date DataChamado) {
        this.DataChamado = DataChamado;
    }

    public Date getDataAtendimentoFim() {
        return DataAtendimentoFim;
    }

    public void setDataAtendimentoFim(Date DataAtendimentoFim) {
        this.DataAtendimentoFim = DataAtendimentoFim;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public void setFuncionario(Long func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
