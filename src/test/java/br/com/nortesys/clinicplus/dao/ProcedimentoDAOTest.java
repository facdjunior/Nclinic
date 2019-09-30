package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class ProcedimentoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            Procedimento procedimento = new Procedimento();

            ConvenioDAO convenioDAO = new ConvenioDAO();
            Convenio convenio = convenioDAO.buscar(1L);

            ListaProcedimentoDAO listaProcedimentoDAO = new ListaProcedimentoDAO();
            ListaProcedimento listaProcedimento = listaProcedimentoDAO.listarSequencia();
            ListaProcedimento procedimentoSelecionado = listaProcedimentoDAO.buscar(1L);

            Procedimento resultado = (Procedimento) procedimentoDAO.listarSequencia();

            if (resultado == null) {

                procedimento.setSequencia(1L);
                procedimento.setConvenio(convenio);
                procedimento.setProcedimento(procedimentoSelecionado.getDescricao());
                procedimento.setCodigoANS("10101012");
                procedimento.setDataCadastro(new Date());

            } else {
                procedimento.setSequencia(1L);
                procedimento.setConvenio(convenio);
                procedimento.setProcedimento(procedimentoSelecionado.getDescricao());
                procedimento.setCodigoANS("10101012");
                procedimento.setDataCadastro(new Date());

            }

            procedimentoDAO.merge(procedimento);

            System.out.println("Registro salvo com sucesso");

        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }
    
    public List<ListaProcedimento> listar(String s)
    {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria consulta = sessao.createCriteria(ListaProcedimento.class);
            consulta.addOrder(Order.asc("Descricao"));
            consulta.add(Restrictions.like("Descricao", s + "%"));
            return consulta.list();
        }finally
        {
            sessao.close();
        }
    }

}
