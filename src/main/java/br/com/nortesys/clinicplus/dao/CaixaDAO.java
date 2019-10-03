package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class CaixaDAO extends GenericDAO<Caixa>{
    
    
    public Caixa listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Caixa.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Caixa caixa = (Caixa) consulta.uniqueResult();

            if (consulta == null) {
                caixa.setSequencia(1L);
            }
            return caixa;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
