package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class EnderecoDAO extends GenericDAO<Endereco> {

    @SuppressWarnings("unchecked")
    public Endereco listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Endereco.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Endereco endereco = (Endereco) consulta.uniqueResult();

           
            return endereco;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
