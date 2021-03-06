package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cidade;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class CidadeDAO extends GenericDAO<Cidade>{
    
    public Cidade listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Cidade.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Cidade cidade = (Cidade) consulta.uniqueResult();

            if (consulta == null) {
                cidade.setSequencia(1L);
            }
            return cidade;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
