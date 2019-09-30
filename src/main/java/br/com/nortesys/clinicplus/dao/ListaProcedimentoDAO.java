package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.dao.GenericDAO;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class ListaProcedimentoDAO extends GenericDAO<ListaProcedimento>{
    
    @SuppressWarnings("unchecked")
    public ListaProcedimento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(ListaProcedimento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            ListaProcedimento listaProcedimento = (ListaProcedimento) consulta.uniqueResult();

            return listaProcedimento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
