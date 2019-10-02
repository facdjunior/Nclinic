package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.ModalidadeLancamento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class ModalidadeLancamentoDAO extends GenericDAO<ModalidadeLancamento>{
    
    @SuppressWarnings("unchecked")
    public ModalidadeLancamento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(ModalidadeLancamento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            ModalidadeLancamento modalidadeLancamento = (ModalidadeLancamento) consulta.uniqueResult();

            return modalidadeLancamento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
