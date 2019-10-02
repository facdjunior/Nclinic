package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoLancamentos;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class TipoLancamentoDAO extends GenericDAO<TipoLancamentos>{
    
    @SuppressWarnings("unchecked")
    public TipoLancamentos listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(TipoLancamentos.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            TipoLancamentos tipoLancamento = (TipoLancamentos) consulta.uniqueResult();

            return tipoLancamento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
