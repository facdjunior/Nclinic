package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Profissao;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Order;


/**
 *
 * @author Francisco
 */
public class ProfissaoDAO extends GenericDAO<Profissao> {
    
    @SuppressWarnings("unchecked")
    public Profissao listarSequencia() {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {

            Criteria consulta = sessao.createCriteria(Profissao.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Profissao profissao = (Profissao) consulta.uniqueResult();
            
            
            if(consulta == null){
                profissao.setSequencia(1);
            }
            return profissao;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }

}
