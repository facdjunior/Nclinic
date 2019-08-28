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

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = new Profissao();

        try {

            
            Profissao resultado = (Profissao) profissaoDAO.listarSequencia();

            if (resultado == null) {
                profissao.setSequencia(1);
                profissao.setDataCadastro(new Date());
                profissao.setDescricao("Governador");
                profissao.setCBO("111900");
                profissaoDAO.merge(profissao);

                System.out.println("Registro Salvo com Sucesso!");
                return;
            }

            profissao.setSequencia(resultado.getSequencia() + 1);
            profissao.setDataCadastro(new Date());
            profissao.setDescricao("Governador");
            profissao.setCBO("111900");
            profissaoDAO.merge(profissao);

            System.out.println("Foi para sequencia");
            //               return;

        } catch (RuntimeException e) {
            System.out.println("Erro ao gravar Registro" + e);
        }
    }
}
