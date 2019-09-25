package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

                pessoaFisica.setSequencia(1);
            }
            return pessoaFisica;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public String idade() {

        PessoaFisica pessoaFisica = new PessoaFisica();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);

        Date dataInicio = pessoaFisica.getDataNascimento();
        Date dataAtual = new Date();

        long dt = (dataAtual.getTime() - dataInicio.getTime()) + 3600000;
        Long diasCorridoAnoLong = (dt / 86400000L);

        Integer DiasDecorridosInt = (Integer.valueOf(diasCorridoAnoLong.toString()));

        String diasDecorridos = String.valueOf(DiasDecorridosInt);

        return diasDecorridos;
    }
}
