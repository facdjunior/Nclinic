package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoDocumento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class TipoDocumentoDAO extends GenericDAO<TipoDocumento>{
    
    @SuppressWarnings("unchecked")
    public TipoDocumento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(TipoDocumento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            TipoDocumento tipoConvenio = (TipoDocumento) consulta.uniqueResult();

            if (consulta == null) {
                tipoConvenio.setSequencia(1L);
            }
            return tipoConvenio;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
