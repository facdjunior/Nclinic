package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Profissao;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Francisco
 */
public class ProfissaoDAO extends GenericDAO<Profissao> {

    // @SuppressWarnings("unchecked")
    public Profissao sequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

           // ProfissaoDAO profissaoDAO = new ProfissaoDAO();
            Profissao profissao = new Profissao();

            Criteria consulta = sessao.createCriteria(Profissao.class);
            consulta.setMaxResults(1);
            int Sequencia = 0;
            profissao = (Profissao) consulta.uniqueResult();

           
                return profissao;
            
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
