package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.dao.ProcedimentoDAO;
import br.com.nortesys.clinicplus.dao.RelProcedimentoConvenioAssociadoDAO;
import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
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

    private RelProcedimentoConvenioAssociado procedimento;
    private List<RelProcedimentoConvenioAssociado> procedimentos;

    private Procedimento listaProcedimento;
    private List<Procedimento> listaProcedimentos;

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

    public RelProcedimentoConvenioAssociado getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(RelProcedimentoConvenioAssociado procedimento) {
        this.procedimento = procedimento;
    }

    public List<RelProcedimentoConvenioAssociado> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<RelProcedimentoConvenioAssociado> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public Procedimento getListaProcedimento() {
        return listaProcedimento;
    }

    public void setListaProcedimento(Procedimento listaProcedimento) {
        this.listaProcedimento = listaProcedimento;
    }

    public List<Procedimento> getListaProcedimentos() {
        return listaProcedimentos;
    }

    public void setListaProcedimentos(List<Procedimento> listaProcedimentos) {
        this.listaProcedimentos = listaProcedimentos;
    }

    @PostConstruct
    public void listar() {
        try {

            RelProcedimentoConvenioAssociadoDAO procedimentoDAO = new RelProcedimentoConvenioAssociadoDAO();
            procedimentos = procedimentoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        procedimento = new RelProcedimentoConvenioAssociado();
        listaProcedimento = new Procedimento();
        convenio = new Convenio();

        ProcedimentoDAO listaProcedimentoDAO = new ProcedimentoDAO();
        listaProcedimentos = listaProcedimentoDAO.listar("Descricao");

        ConvenioDAO convenioDAO = new ConvenioDAO();
        convenios = convenioDAO.listar("Descricao");
    }
    
    public void salvar(){
        
        try {
            
            RelProcedimentoConvenioAssociadoDAO procedimentoDAO = new RelProcedimentoConvenioAssociadoDAO();
            RelProcedimentoConvenioAssociado resultadoProcedimento = procedimentoDAO.listarSequencia();
            
            if(resultadoProcedimento==null){
                procedimento.setSequencia(1L);
                procedimento.setDataCadastro(new Date());
            }else{
                procedimento.setSequencia(resultadoProcedimento.getSequencia()+1);
                procedimento.setDataCadastro(new Date());
            }
            
            procedimentoDAO.merge(procedimento);
            Messages.addGlobalInfo("Registro Salvo com Sucesso");
            
            novo();
            listar();
            
        } catch (RuntimeException erro) {
            
            Messages.addGlobalError("Erro ao tentar gravar registro!");
            erro.printStackTrace();
        }
    }

    public void popular() {

        try {

            

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Ocorreu um ero ao tentar filtrar as cidades");
            erro.printStackTrace();
        }
    }

}
