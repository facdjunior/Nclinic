package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.LancamentoCaixa;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class LancamentoCaixaDAO extends GenericDAO<LancamentoCaixa> {

    @SuppressWarnings("unchecked")
    public LancamentoCaixa listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(LancamentoCaixa.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            LancamentoCaixa lancamentoCaixa = (LancamentoCaixa) consulta.uniqueResult();

            return lancamentoCaixa;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
