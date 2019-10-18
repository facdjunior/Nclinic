package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Empresa;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */

public class EmpresaDAO extends GenericDAO<Empresa>{
    
    @SuppressWarnings("unchecked")
    public Empresa listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Empresa.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Empresa entidade = (Empresa) consulta.uniqueResult();

            return entidade;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
