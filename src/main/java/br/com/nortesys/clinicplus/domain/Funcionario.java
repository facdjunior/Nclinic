package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
public class Funcionario extends GenericDomain{
    
    @Column(nullable = false)
    @SequenceGenerator(name = "Sequencia", initialValue = 1)
    @Expose
    private Integer Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose
    private Date DataCadastro;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Expose
    private Pessoa pessoa;
    
    @OneToOne
    @JoinColumn(nullable = false)
    @Expose
    private TipoFuncionario tipoFuncionario;
    
    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    public Funcionario(){
        
        pessoa = new Pessoa();
    }
}
