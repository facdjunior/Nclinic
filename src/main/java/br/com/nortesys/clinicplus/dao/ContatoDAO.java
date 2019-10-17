package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class ContatoDAO extends GenericDAO<Contato> {

    @SuppressWarnings("unchecked")
    public Contato listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Contato.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Contato contato = (Contato) consulta.uniqueResult();

            return contato;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
