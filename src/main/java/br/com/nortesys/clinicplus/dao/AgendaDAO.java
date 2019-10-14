package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Agenda;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
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
public class AgendaDAO extends GenericDAO<Agenda>{
    
    
    public List<RelProcedimentoConvenioAssociado> buscarPorConvenio(Long convenioCodigo){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(RelProcedimentoConvenioAssociado.class);
            consulta.add(Restrictions.eq("convenio.codigo", convenioCodigo));
            
            consulta.addOrder(Order.asc("codigo"));
            List<RelProcedimentoConvenioAssociado> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        }finally{
            sessao.close();
        }
    }
}
