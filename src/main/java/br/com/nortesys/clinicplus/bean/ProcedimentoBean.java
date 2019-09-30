package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ListaProcedimentoDAO;
import br.com.nortesys.clinicplus.dao.ProcedimentoDAO;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.domain.Procedimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

        ListaProcedimentoDAO listaProcedimentoDAO = new ListaProcedimentoDAO();
        listaProcedimentos = listaProcedimentoDAO.listar("Descricao");
    }

    String nomeProduto;

    public List<String> listar(String s) {
        List<String> results = new ArrayList<String>();
        for (ListaProcedimento p : new ListaProcedimentoDAO().lista(s)) {
            results.add(p.getNome());
        }
        return results;

    }

}
