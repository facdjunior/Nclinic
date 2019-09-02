package br.com.nortesys.clinicplus.dao;


import br.com.nortesys.clinicplus.domain.Funcionario;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class FuncionarioDAO extends GenericDAO<Funcionario>{
    
    @SuppressWarnings("unchecked")
    public Funcionario listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Funcionario.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Funcionario funcionario = (Funcionario) consulta.uniqueResult();

            if (consulta == null) {
                funcionario.setSequencia(1);
            }
            return funcionario;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
