package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Profissao;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ProfissaoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        Profissao profissao = new Profissao();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
//        profissaoDAO.sequencia();
        try {

            if (profissao.getSequencia() == null) {

                profissaoDAO.sequencia();

                System.out.println("Foi para sequencia");
                //return;
            } else {
                profissao.setSequencia(profissaoDAO.sequencia().getSequencia()+ 1);
                profissao.setDataCadastro(new Date());
                profissao.setDescricao("Prefeito");
                profissao.setCBO("111250");
                profissaoDAO.merge(profissao);

                System.out.println("Registro Salvo com Sucesso!");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao gravar Registro" + e);
        }
    }
    
     @Test
    //@Ignore
    public void sequencia() {
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = new Profissao();
       // profissaoDAO.sequencia();

        //int estoqueAtual = produto.getQuantidade() - itemVenda.getQuantidade();
        if (profissao.getSequencia() == null) {
            int Maximo = 0;
            profissao.setSequencia(Maximo + 1);

            System.out.println(+profissao.getCodigo() + "-" + profissao.getSequencia());
            return;
        }

        profissao.setSequencia(profissao.getSequencia() + 1);
        System.out.println("Passou: " + profissao.getCodigo() + "--" + profissao.getSequencia());
    }

}
