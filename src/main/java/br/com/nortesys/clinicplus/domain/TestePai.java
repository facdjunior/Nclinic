package br.com.nortesys.clinicplus.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class TestePai extends GenericDomain{
    
    
    private String Nome;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private TesteFilho testeFilho;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public TesteFilho getTesteFilho() {
        return testeFilho;
    }

    public void setTesteFilho(TesteFilho testeFilho) {
        this.testeFilho = testeFilho;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    
    
    
    
}
