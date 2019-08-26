package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.Pessoa;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class EnderecoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(5L);

        Endereco endereco = new Endereco();

        endereco.setAtivo(true);
        endereco.setBairro("Porto Novo");
        endereco.setDescricao("Rua Mato Grosso I");
        endereco.setCEP("29155-430");
        endereco.setSequencia(3L);
        endereco.setComplemento("João teste Complemento");
        endereco.setDataCadastro(new Date());
        endereco.setNumero("561");
        endereco.setObservacao("Cariacica");
        
        endereco.setPessoa(pessoa);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.merge(endereco);

    }
}
