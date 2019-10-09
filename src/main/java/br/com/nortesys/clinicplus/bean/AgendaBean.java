package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.AgendaDAO;
import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.dao.FuncionarioDAO;
import br.com.nortesys.clinicplus.dao.ListaProcedimentoDAO;

import br.com.nortesys.clinicplus.dao.TipoAtendimentoDAO;
import br.com.nortesys.clinicplus.domain.Agenda;
import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Funcionario;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.TipoAtendimento;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Francisco
 */
@ManagedBean
@ViewScoped
public class AgendaBean implements Serializable {

    private Funcionario funcionario;

    private Agenda agenda;

    private Cliente cliente;

    private Pessoa pessoa;

    private List<Agenda> listaEvento;

    private ScheduleModel eventeModel;

    private List<Funcionario> funcionarios;

    private TipoAtendimento tipoAtendimento;
    private List<TipoAtendimento> tipoAtendimentos;

    private Convenio convenio;
    private List<Convenio> convenios;

    private AgendaDAO eDao;

    private ListaProcedimento listaProcedimento;
    private List<ListaProcedimento> listaProcedimentos;

    public ListaProcedimento getListaProcedimento() {
        return listaProcedimento;
    }

    public void setListaProcedimento(ListaProcedimento listaProcedimento) {
        this.listaProcedimento = listaProcedimento;
    }

    public List<ListaProcedimento> getListaProcedimentos() {
        return listaProcedimentos;
    }

    public void setListaProcedimentos(List<ListaProcedimento> listaProcedimentos) {
        this.listaProcedimentos = listaProcedimentos;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public List<TipoAtendimento> getTipoAtendimentos() {
        return tipoAtendimentos;
    }

    public void setTipoAtendimentos(List<TipoAtendimento> tipoAtendimentos) {
        this.tipoAtendimentos = tipoAtendimentos;
    }

    public AgendaDAO geteDao() {
        return eDao;
    }

    public void seteDao(AgendaDAO eDao) {
        this.eDao = eDao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Agenda> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<Agenda> listaEvento) {
        this.listaEvento = listaEvento;
    }

    public ScheduleModel getEventeModel() {
        return eventeModel;
    }

    public void setEventeModel(ScheduleModel eventeModel) {
        this.eventeModel = eventeModel;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @PostConstruct
    public void inicializar() {

        eDao = new AgendaDAO();
        agenda = new Agenda();
        eventeModel = new DefaultScheduleModel();

        TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO();
        tipoAtendimentos = tipoAtendimentoDAO.listar();

        ConvenioDAO convenioDAO = new ConvenioDAO();
        convenios = convenioDAO.listar("Descricao");

        ListaProcedimentoDAO listaProcedimentoDAO = new ListaProcedimentoDAO();
        listaProcedimentos = listaProcedimentoDAO.listar("Descricao");

        try {

            listaEvento = eDao.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar agenda");
            erro.printStackTrace();;
        }
        for (Agenda ag : listaEvento) {

            DefaultScheduleEvent evt = new DefaultScheduleEvent();

            evt.setEndDate(ag.getDataAtendimentoFim());
            evt.setStartDate(ag.getDataAtendimentoInicio());
            evt.setTitle(ag.getNome());
            evt.setData(ag.getCodigo());
            evt.setDescription(ag.getNome());
            evt.setAllDay(true);
            evt.setEditable(true);
            
            if(ag.getDataChamado()==null){
                evt.setStyleClass("emp1");
            }else if(ag.getDataChamado() !=null){
                evt.setStyleClass("emp2");
            }

            eventeModel.addEvent(evt);
        }

    }

    public void quandoSelecionado(SelectEvent selectEvent) {

        ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();

        for (Agenda ev : listaEvento) {
            if (ev.getCodigo() == (Long) event.getData()) {
                agenda = ev;
                break;
            }
        }
    }

    public void quandoNovo(SelectEvent selectEvent) {

        ScheduleEvent event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        agenda = new Agenda();
        agenda.setDataAtendimentoInicio(new java.sql.Date(event.getStartDate().getTime()));
        agenda.setDataAtendimentoFim(new java.sql.Date(event.getEndDate().getTime()));
    }

    public void salvar() {

        if (agenda.getCodigo() == null) {
            if (agenda.getDataAtendimentoInicio().getTime() <= agenda.getDataAtendimentoFim().getTime()) {
                eDao = new AgendaDAO();
                Long func = 1L;
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                funcionario = funcionarioDAO.buscar(func);
                try {

                    this.agenda.setFuncionario(funcionario);
                    eDao.merge(agenda);
                    Messages.addGlobalInfo("Registro salvo com sucesso");
                    inicializar();

                } catch (RuntimeException erro) {

                    Messages.addGlobalError("Erro ao tentar gravar regristo!");
                    erro.printStackTrace();

                }
                agenda = new Agenda();
            } else {
                Messages.addGlobalError("Data inicial não pode ser maior que Data final");
            }
        } else {
            eDao = new AgendaDAO();
            try {

                this.agenda.setFuncionario(funcionario);
                eDao.merge(agenda);
                inicializar();
                Messages.addGlobalInfo("Registro salvo com sucesso");
            } catch (RuntimeException erro) {

                Messages.addGlobalError("Erro ao tentar gravar regristo!");

            }
        }
    }

    public void quandoMovido(ScheduleEntryMoveEvent event) {
        for (Agenda ag : listaEvento) {
            if (ag.getCodigo() == (Long) event.getScheduleEvent().getData()) {
                agenda = ag;
                eDao = new AgendaDAO();
                try {

                    eDao.merge(agenda);
                    Messages.addGlobalInfo("Registro atualizado com sucesso");

                    inicializar();

                } catch (RuntimeException erro) {
                    Messages.addGlobalError("Erro ao Atualizar agenda");
                    erro.printStackTrace();
                }
                break;
            }
        }
    }

    public void quandoRedimencionado(ScheduleEntryResizeEvent event) {

        for (Agenda ag : listaEvento) {
            if (ag.getCodigo() == (Long) event.getScheduleEvent().getData()) {
                agenda = ag;
                eDao = new AgendaDAO();
                try {

                    eDao.merge(agenda);
                    Messages.addGlobalInfo("Registro atualizado com sucesso");

                    inicializar();

                } catch (RuntimeException erro) {
                    Messages.addGlobalError("Erro ao Atualizar agenda");
                    erro.printStackTrace();
                }
                break;
            }
        }

    }
}
