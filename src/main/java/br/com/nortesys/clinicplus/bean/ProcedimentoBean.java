package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.dao.ListaProcedimentoDAO;
import br.com.nortesys.clinicplus.dao.ProcedimentoDAO;
import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProcedimentoBean implements Serializable {

    private Procedimento procedimento;
    private List<Procedimento> procedimentos;

    private ListaProcedimento listaProcedimento;
    private List<ListaProcedimento> listaProcedimentos;

    private Convenio convenio;
    private List<Convenio> convenios;

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

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

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

    @PostConstruct
    public void listar() {
        try {

            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            procedimentos = procedimentoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        procedimento = new Procedimento();
        listaProcedimento = new ListaProcedimento();
        convenio = new Convenio();

        ListaProcedimentoDAO listaProcedimentoDAO = new ListaProcedimentoDAO();
        listaProcedimentos = listaProcedimentoDAO.listar("Descricao");

        ConvenioDAO convenioDAO = new ConvenioDAO();
        convenios = convenioDAO.listar("Descricao");
    }
    
    public void salvar(){
        
        try {
            
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            Procedimento resultadoProcedimento = procedimentoDAO.listarSequencia();
            
            if(resultadoProcedimento==null){
                procedimento.setSequencia(1L);
                procedimento.setDataCadastro(new Date());
            }else{
                procedimento.setSequencia(resultadoProcedimento.getSequencia()+1);
                procedimento.setDataCadastro(new Date());
            }
            
            procedimentoDAO.merge(procedimento);
            Messages.addGlobalInfo("Registro Salvo com Sucesso");
            
        } catch (RuntimeException erro) {
            
            Messages.addGlobalError("Erro ao tentar gravar registro!");
            erro.printStackTrace();
        }
    }

    public void popular() {

        try {

            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            ListaProcedimento rest = procedimentoDAO.buscarProcedimento(this.procedimento.getListaProcedimento().getCodigo());

            this.procedimento.getListaProcedimento().setCodigoANS(rest.getCodigoANS());

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Ocorreu um ero ao tentar filtrar as cidades");
            erro.printStackTrace();
        }
    }

}
