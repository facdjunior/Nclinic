
package br.com.nortesys.clinicplus.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francisco
 */
@Embeddable
public class EmpresaID implements Serializable{
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "codigo")
    private Empresa empresa;
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EmpresaID() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.empresa);
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
        final EmpresaID other = (EmpresaID) obj;
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return true;
    }

   
    
    
}
