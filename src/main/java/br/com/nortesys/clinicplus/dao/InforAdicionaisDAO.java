/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.InforAdicionais;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Francisco
 */
public class InforAdicionaisDAO extends GenericDAO<InforAdicionais>{
    /* 
    @SuppressWarnings("unchecked")
    public InforAdicionais listarSequencia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(InforAdicionais.class);
            consulta.addOrder(Order.desc("Sequencia"));
            consulta.setMaxResults(1);

            InforAdicionais inforAdicionais = (InforAdicionais) consulta.uniqueResult();

           if (consulta == null) {
                inforAdicionais.setDataCadastro(new Date());
                pessoa.setSequencia(1L);
            } else {
                pessoa.setDataCadastro(new Date());
                pessoa.setSequencia(pessoa.getSequencia() + 1L);

            }
            return pessoa;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
    */
}
