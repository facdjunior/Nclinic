package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.dao.GenericDAO;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco Junior
 */
public class ProcedimentoDAO extends GenericDAO<Procedimento> {

    @SuppressWarnings("unchecked")
    public Procedimento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Procedimento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Procedimento procedimento = (Procedimento) consulta.uniqueResult();

            return procedimento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public List<ListaProcedimento> listarProcedimento(String s)
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

//https://respostas.guj.com.br/28523-autocomplete-com-primefaces-e-hibernate
