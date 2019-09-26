package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class DocumentoDAO extends GenericDAO<Documento>{
    
    @SuppressWarnings("unchecked")
    public Documento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Documento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Documento documento = (Documento) consulta.uniqueResult();

            return documento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
