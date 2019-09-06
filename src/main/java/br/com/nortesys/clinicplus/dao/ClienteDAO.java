package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    @SuppressWarnings("unchecked")
    public Cliente listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Cliente.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Cliente cliente = (Cliente) consulta.uniqueResult();

            if (consulta == null) {
                cliente.setSequencia(1);
            }
            return cliente;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
   
    
}
