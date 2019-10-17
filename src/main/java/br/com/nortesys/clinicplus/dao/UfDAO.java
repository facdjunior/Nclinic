package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.UF;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class UfDAO extends GenericDAO<UF>{
    
    @SuppressWarnings("unchecked")
    public UF listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(UF.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            UF uf = (UF) consulta.uniqueResult();

            return uf;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
