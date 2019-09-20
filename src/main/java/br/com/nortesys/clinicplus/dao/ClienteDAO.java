package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;

import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.omnifaces.util.Messages;

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

            List<Cliente> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {

            throw erro;
        } finally {
            sessao.close();
        }
    }
}
