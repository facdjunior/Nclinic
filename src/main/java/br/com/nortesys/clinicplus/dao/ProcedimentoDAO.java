package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.dao.GenericDAO;
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

    
}
