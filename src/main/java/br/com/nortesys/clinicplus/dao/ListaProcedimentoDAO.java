package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.dao.GenericDAO;
import br.com.nortesys.clinicplus.domain.ListaProcedimento;
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
public class ListaProcedimentoDAO extends GenericDAO<ListaProcedimento> {

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
