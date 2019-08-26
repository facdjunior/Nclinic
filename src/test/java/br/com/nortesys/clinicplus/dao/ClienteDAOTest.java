package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
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
        Endereco endereco = new Endereco();
        Pessoa pessoa = new Pessoa();
        Cliente cliente = new Cliente();
        
        String data = "27/08/1946";
        pessoaFisica.setDataCadastro(new Date());
        pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
        pessoaFisica.setEstadoCivil(estadoCivil);
        pessoaFisica.setGrauEscolaridade("3º Grau");
        pessoaFisica.setNaturalidade("Tocantins");
        pessoaFisica.setSequencia(4);
        pessoaFisica.setSexo('F');

        pessoa.setNome("Carlos Eduardo Sebastião Henry Baptista");
        pessoa.setDataCadastro(new Date());
        pessoa.setSequencia(4L);
        pessoa.setPessoaFisica(pessoaFisica);

        endereco.setAtivo(true);
        endereco.setBairro("Porto Novo");
        endereco.setDescricao("Rua Mato Grosso I");
        endereco.setCEP("29155-430");
        endereco.setSequencia(2L);
        endereco.setComplemento("João teste Complemento");
        endereco.setDataCadastro(new Date());
        endereco.setNumero("561");
        endereco.setObservacao("Cariacica");

        endereco.setPessoa(pessoa);


        cliente.setDataCadastro(new Date());
        cliente.setPessoa(pessoa);
        cliente.setSequencia(4);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.merge(cliente);

    }

}
