package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Funcionario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Francisco
 */
@ManagedBean
@ViewScoped
public class AgendaBean {
    
    private ScheduleModel agendas;
    
    private List<Funcionario> funcionarios;

    public ScheduleModel getAgendas() {
        return agendas;
    }

    public void setAgendas(ScheduleModel agendas) {
        this.agendas = agendas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    
    @PostConstruct
    public void listar(){
        agendas = new DefaultScheduleModel();
    }
    
}
