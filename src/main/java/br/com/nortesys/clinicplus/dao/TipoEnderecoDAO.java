package br.com.nortesys.clinicplus.dao;


import br.com.nortesys.clinicplus.domain.TipoEndereco;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class TipoEnderecoDAO extends GenericDAO<TipoEndereco>{
    
    @SuppressWarnings("unchecked")
    public TipoEndereco listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(TipoEndereco.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            TipoEndereco tipoEndereco = (TipoEndereco) consulta.uniqueResult();

            if (consulta == null) {
                tipoEndereco.setSequencia(1L);
            }
            return tipoEndereco;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
}
