package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.PessoaJuridica;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class PessoaJuridicaDAO extends GenericDAO<PessoaJuridica>{
    
    @SuppressWarnings("unchecked")
    public PessoaJuridica listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(PessoaJuridica.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            PessoaJuridica pessoaJuridica = (PessoaJuridica) consulta.uniqueResult();

            return pessoaJuridica;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
