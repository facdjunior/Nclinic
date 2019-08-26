package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TesteFilho;
import br.com.nortesys.clinicplus.domain.TestePai;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class TestePaiTest {

    @Test
    @Ignore
    public void salvar() {

        TestePai testePai = new TestePai();
        TesteFilho testeFilho = new TesteFilho();
        testePai.setDataCadastro(new Date());
        testePai.setNome("Nome Teste Pai2");
        testePai.setTesteFilho(testeFilho);

        testeFilho.setDataCadastro(new Date());
        testeFilho.setDescricao("Teste Filho2");

        TestePaiDAO testePaiDAO = new TestePaiDAO();

        testePaiDAO.merge(testePai);

    }

}
