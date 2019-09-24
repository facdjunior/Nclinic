package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */


@SuppressWarnings("Serial")
@Entity
public class PessoaFisica extends GenericDomain {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @Expose(serialize = true)
    private Date DataNascimento;

    @Column(nullable = false)
    @Expose(serialize = true)
    private Integer Sequencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Expose(serialize = true)
    private Date DataCadastro;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Expose(serialize = true)
    private EstadoCivil estadoCivil;

    @Column(length = 1)
    @Expose(serialize = true)
    private Character Sexo;

    @Column(length = 25)
    @Expose(serialize = true)
    private String Naturalidade;

    @Column(length = 30)
    @Expose(serialize = true)
    private String GrauEscolaridade;
    
    private Character Tratamento;

    @ManyToOne
    @Expose(serialize = true)
    private Profissao profissao;

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Character getSexo() {
        return Sexo;
    }

    public void setSexo(Character Sexo) {
        this.Sexo = Sexo;
    }

    public String getNaturalidade() {
        return Naturalidade;
    }

    public void setNaturalidade(String Naturalidade) {
        this.Naturalidade = Naturalidade;
    }

    public String getGrauEscolaridade() {
        return GrauEscolaridade;
    }

    public void setGrauEscolaridade(String GrauEscolaridade) {
        this.GrauEscolaridade = GrauEscolaridade;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Character getTratamento() {
        return Tratamento;
    }

    public void setTratamento(Character Tratamento) {
        this.Tratamento = Tratamento;
    }
    
    public PessoaFisica(){
        
    }
}
