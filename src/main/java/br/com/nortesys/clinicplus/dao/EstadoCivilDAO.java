package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class EstadoCivilDAO extends GenericDAO<EstadoCivil> {

    public EstadoCivil listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(EstadoCivil.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            EstadoCivil estadoCivil = (EstadoCivil) consulta.uniqueResult();

            if (consulta == null) {
                estadoCivil.setSequencia(1);
            }
            return estadoCivil;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
