package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco Junior
 */
public class PessoaFisicaDAO extends GenericDAO<PessoaFisica> {

    @SuppressWarnings("unchecked")
    public PessoaFisica listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(PessoaFisica.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            PessoaFisica pessoaFisica = (PessoaFisica) consulta.uniqueResult();

            if (consulta == null) {
                pessoaFisica.setDataCadastro(new Date());
                pessoaFisica.setSequencia(1);
            } else {
                pessoaFisica.setDataCadastro(new Date());
                pessoaFisica.setSequencia(pessoaFisica.getSequencia() + 1);
                
            }
            return pessoaFisica;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
}
