package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.CartaoConvenio;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class CartaoConvenioDAO extends GenericDAO<CartaoConvenio>{
    
    @SuppressWarnings("unchecked")
    public CartaoConvenio listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(CartaoConvenio.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            CartaoConvenio cartaoConvenio = (CartaoConvenio) consulta.uniqueResult();

            if (consulta == null) {
                cartaoConvenio.setSequencia(1L);
            }
            return cartaoConvenio;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
