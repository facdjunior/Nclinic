package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Pessoa;

import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.omnifaces.util.Messages;


/**
 *
 * @author Francisco
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    @SuppressWarnings("unchecked")
    public Cliente listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Cliente.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            Cliente cliente = (Cliente) consulta.uniqueResult();

            if (consulta == null) {
                cliente.setSequencia(1);
            }
            return cliente;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public void dependencia(){
        
        try {
            
            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa resultado = (Pessoa) pessoaDAO.listarSequencia();
            Pessoa pessoa = new Pessoa();
              
            if (resultado == null) {

                    pessoa.setDataCadastro(new Date());
                    pessoa.setSequencia(1L);
                    

                } else {

                    pessoa.setDataCadastro(new Date());
                    pessoa.setSequencia(resultado.getSequencia() + 1);
                    
                }
           
            //Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Erro ao tentar gravar Registro");
            erro.printStackTrace();
        }
        
    }
    

}
