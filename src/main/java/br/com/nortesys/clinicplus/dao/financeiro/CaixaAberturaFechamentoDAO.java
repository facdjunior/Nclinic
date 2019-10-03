package br.com.nortesys.clinicplus.dao.financeiro;

import br.com.nortesys.clinicplus.dao.GenericDAO;
import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import br.com.nortesys.clinicplus.domain.financeiro.CaixaAberturaFechamento;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco Junior
 */
public class CaixaAberturaFechamentoDAO extends GenericDAO<CaixaAberturaFechamento> {

    public CaixaAberturaFechamento listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(CaixaAberturaFechamento.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            CaixaAberturaFechamento aberturaFechamento = (CaixaAberturaFechamento) consulta.uniqueResult();

            if (consulta == null) {
                aberturaFechamento.setSequencia(1L);
            }
            return aberturaFechamento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<Caixa> listarCaixa(Caixa caixa) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria criteria = sessao.createCriteria(Caixa.class);
            criteria.add(Restrictions.eq("dataFechamento", null));
            return criteria.list();

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }

}
