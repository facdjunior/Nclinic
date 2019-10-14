package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.ConvenioAssociado;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class ConvenioAssociadoDAO extends GenericDAO<ConvenioAssociado> {

    @SuppressWarnings("unchecked")
    public ConvenioAssociado listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(ConvenioAssociado.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            ConvenioAssociado convenioAssociado = (ConvenioAssociado) consulta.uniqueResult();

            return convenioAssociado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
