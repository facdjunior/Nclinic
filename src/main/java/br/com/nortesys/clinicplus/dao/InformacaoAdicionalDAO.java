package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.InformacaoAdicional;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */

public class InformacaoAdicionalDAO extends GenericDAO<InformacaoAdicional>{
 
    @SuppressWarnings("unchecked")
    public InformacaoAdicional listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(InformacaoAdicional.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            InformacaoAdicional inforAdicional = (InformacaoAdicional) consulta.uniqueResult();

           
            return inforAdicional;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
    
}
