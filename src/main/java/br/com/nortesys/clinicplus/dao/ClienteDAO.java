package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;

import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


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

    public List<Cliente> listaCliente() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Cliente.class);
            consulta.createAlias("pessoa", "p");
            consulta.createAlias("p.contato", "c");
            consulta.createAlias("p.endereco", "e");
            consulta.createAlias("p.documento", "d");
            consulta.createAlias("p.cartaoConvenio", "cc");
            consulta.createAlias("p.inforAdicionais", "i");

            List<Cliente> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {

            throw erro;
        } finally {
            sessao.close();
        }
    }

    public Cliente buscarCliente(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Cliente.class);
            consulta.createAlias("pessoa", "p");
            consulta.createAlias("p.contato", "c");
            consulta.createAlias("p.endereco", "e");
            consulta.createAlias("p.documento", "d");
            consulta.createAlias("p.cartaoConvenio", "cc");
            consulta.createAlias("p.inforAdicionais", "i");
            consulta.add(Restrictions.idEq(codigo));

            Cliente resultado = (Cliente) consulta.uniqueResult();

            return resultado;
        } catch (RuntimeException erro) {

            throw erro;
        } finally {
            sessao.close();
        }
    }
}
