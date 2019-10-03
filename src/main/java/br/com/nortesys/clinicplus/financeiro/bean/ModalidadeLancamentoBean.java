package br.com.nortesys.clinicplus.financeiro.bean;

import br.com.nortesys.clinicplus.domain.financeiro.ModalidadeLancamento;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco Junior
 */

@ViewScoped
@ManagedBean
public class ModalidadeLancamentoBean implements Serializable{
    
    private ModalidadeLancamento modalidadeLancamento;
    
    private List<ModalidadeLancamento> modalidadeLancamentos;

    public ModalidadeLancamento getModalidadeLancamento() {
        return modalidadeLancamento;
    }

    public void setModalidadeLancamento(ModalidadeLancamento modalidadeLancamento) {
        this.modalidadeLancamento = modalidadeLancamento;
    }

    public List<ModalidadeLancamento> getModalidadeLancamentos() {
        return modalidadeLancamentos;
    }

    public void setModalidadeLancamentos(List<ModalidadeLancamento> modalidadeLancamentos) {
        this.modalidadeLancamentos = modalidadeLancamentos;
    }
    
    
    public void listar(){
        
    }
    
    public void novo(){
        
    }
    
    public void salvar(){
        
    }
    
    public void excluir(){
        
    }
}
