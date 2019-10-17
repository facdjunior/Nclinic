package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Entidade;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */

public class EntidadeDAO extends GenericDAO<Entidade>{
    
    @SuppressWarnings("unchecked")
    public Entidade listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Entidade.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Entidade entidade = (Entidade) consulta.uniqueResult();

            return entidade;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
