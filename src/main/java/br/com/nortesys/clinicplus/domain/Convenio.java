package br.com.nortesys.clinicplus.domain;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 *
 */
@SuppressWarnings("serial")
@Entity
public class Convenio extends GenericDomain {

    @EmbeddedId
    EmpresaID empresaID;

    @Column(unique = true, nullable = false)
    @Expose
    private Integer Sequencia;

    @Column(length = 90, nullable = false)
    @Expose
    private String Descricao;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Expose
    private Date DataCadastro;

    @Column(length = 12)
    @Expose
    private String RegristroANS;

    @OneToOne
    @JoinColumn(nullable = false)
    private Empresa empresa;

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
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

    public String getRegristroANS() {
        return RegristroANS;
    }

    public void setRegristroANS(String RegristroANS) {
        this.RegristroANS = RegristroANS;
    }

    public EmpresaID getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(EmpresaID empresaID) {
        this.empresaID = empresaID;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    

    
    public Convenio() {

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.empresaID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convenio other = (Convenio) obj;
        if (!Objects.equals(this.empresaID, other.empresaID)) {
            return false;
        }
        return true;
    }

}
