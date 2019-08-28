package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoConvenio;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class TipoConvenioDAO extends GenericDAO<TipoConvenio>{
    
    @SuppressWarnings("unchecked")
    public TipoConvenio listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(TipoConvenio.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            TipoConvenio tipoConvenio = (TipoConvenio) consulta.uniqueResult();

            if (consulta == null) {
                tipoConvenio.setSequencia(1);
            }
            return tipoConvenio;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
