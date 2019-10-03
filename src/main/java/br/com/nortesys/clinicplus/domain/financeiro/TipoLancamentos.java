package br.com.nortesys.clinicplus.domain.financeiro;

import br.com.nortesys.clinicplus.domain.GenericDomain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class TipoLancamentos extends GenericDomain{
    
    @Column(nullable = false)
    private Long Sequencia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date DataCadastro;
    
    @Column(length = 120, nullable = false)
    private String Descricao;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private ModalidadeLancamento modalidadeLancamento;

    public Long getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Long Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public ModalidadeLancamento getModalidadeLancamento() {
        return modalidadeLancamento;
    }

    public void setModalidadeLancamento(ModalidadeLancamento modalidadeLancamento) {
        this.modalidadeLancamento = modalidadeLancamento;
    }
}
