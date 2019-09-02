package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class TipoFuncionarioDAO extends GenericDAO<TipoFuncionario>{
    
    @SuppressWarnings("unchecked")
    public TipoFuncionario listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(TipoFuncionario.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            TipoFuncionario tipoFuncionario = (TipoFuncionario) consulta.uniqueResult();

            if (consulta == null) {
                tipoFuncionario.setSequencia(1);
            }
            return tipoFuncionario;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
