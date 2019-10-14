package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.dao.GenericDAO;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco Junior
 */
public class RelProcedimentoConvenioAssociadoDAO extends GenericDAO<RelProcedimentoConvenioAssociado> {

    @SuppressWarnings("unchecked")
    public RelProcedimentoConvenioAssociado listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(RelProcedimentoConvenioAssociado.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            RelProcedimentoConvenioAssociado procedimento = (RelProcedimentoConvenioAssociado) consulta.uniqueResult();

            return procedimento;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public Procedimento buscarProcedimento(Long codigo) {

          Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Procedimento.class);

            consulta.add(Restrictions.idEq(codigo));
            Procedimento resultado = (Procedimento) consulta.uniqueResult();
            
            return resultado;
            
        } catch (RuntimeException erro) {
            
            throw erro;
            
        } finally {
            sessao.close();
        }
    }
 }

