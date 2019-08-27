package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class ClienteDAOTest {

    @Test
    //@Ignore
    public void salvar() throws ParseException {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        PessoaFisica pessoaFisica = new PessoaFisica();

        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        Contato contato = new Contato();
        Cliente cliente = new Cliente();

        String data = "21/04/1950";
        pessoaFisica.setDataCadastro(new Date());
        pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
        pessoaFisica.setEstadoCivil(estadoCivil);
        pessoaFisica.setGrauEscolaridade("2º Grau");
        pessoaFisica.setNaturalidade("Manaus");
        pessoaFisica.setSequencia(12);
        pessoaFisica.setSexo('F');

        pessoa.setNome("Sérgio André Nicolas Fogaça");
        pessoa.setDataCadastro(new Date());
        pessoa.setSequencia(12L);
        pessoa.setPessoaFisica(pessoaFisica);

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.merge(pessoa);

        endereco.setAtivo(true);
        endereco.setBairro("Monte das Oliveiras");
        endereco.setDescricao("Rua Muiratinga");
        endereco.setCEP("69093-129");
        endereco.setSequencia(7L);
        endereco.setComplemento("João teste Complemento");
        endereco.setDataCadastro(new Date());
        endereco.setNumero("310");
        endereco.setObservacao("Manaus");

        endereco.setPessoa(pessoa);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.salvar(endereco);

        contato.setCelular("(92)98395-0668");
        contato.setDataCadastro(new Date());
        contato.setFone("(92) 3906-2716");
        contato.setPessoa(pessoa);
        contato.setSequencia(1L);

        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.merge(contato);
      

        cliente.setDataCadastro(new Date());
        cliente.setPessoa(pessoa);
        cliente.setSequencia(9);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.merge(cliente);
    }

}
