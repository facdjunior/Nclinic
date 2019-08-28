package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class PessoaDAO extends GenericDAO<Pessoa>{
    
    @SuppressWarnings("unchecked")
    public Pessoa listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Pessoa.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Pessoa pessoa = (Pessoa) consulta.uniqueResult();

            if (consulta == null) {
                pessoa.setSequencia(1L);
            }
            return pessoa;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
    
}
