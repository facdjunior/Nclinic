package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class ConvenioDAO extends GenericDAO<Convenio>{
    
    @SuppressWarnings("unchecked")
    public Convenio listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Convenio.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Convenio convenio = (Convenio) consulta.uniqueResult();

            return convenio;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    public List<Convenio> listaConvenios() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Convenio.class);
            consulta.createAlias("empresa", "e");
            consulta.createAlias("e.convenio", "c");
            
            

            List<Convenio> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {

            throw erro;
        } finally {
            sessao.close();
        }
    }
}
