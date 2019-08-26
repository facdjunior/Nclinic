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

        profissao.setDataCadastro(new Date());
        profissao.setDescricao("Oficial general da marinha");
        profissao.setCBO("10115");
        profissao.setSequencia(Long.MIN_VALUE);

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        profissaoDAO.merge(profissao);

    }

}
