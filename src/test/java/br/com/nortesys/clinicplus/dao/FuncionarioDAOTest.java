package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Funcionario;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class FuncionarioDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(1L);

        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica resultadoPFisica = (PessoaFisica) pessoaFisicaDAO.listarSequencia();

        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa resultadoPessoa = (Pessoa) pessoaDAO.listarSequencia();

        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco resultaEndereco = (Endereco) enderecoDAO.listarSequencia();

        Documento documento = new Documento();
        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento resultadoDocumento = (Documento) documentoDAO.listarSequencia();

        if (resultadoPessoa == null) {

            pessoa.setNome("Sérgio André Nicolas Fogaça");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);

            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Bento Felipe Yago Figueiredo");
            pessoa.setDataCadastro(new Date());

        }
        if (resultadoPFisica == null) {

            String data = "21/04/1950";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Manaus");
            pessoaFisica.setSequencia(1);
            pessoaFisica.setSexo('F');
        } else {

            String data = "21/04/1950";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Manaus");
            pessoaFisica.setSequencia(resultadoPFisica.getSequencia() + 1);
            pessoaFisica.setSexo('F');
        }

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

        if (resultadoContato == null) {

            pessoa.getContato().setDataCadastro(new Date());

            pessoa.getContato().setPessoa(pessoa);
            pessoa.getContato().setSequencia(1L);

        } else {

            pessoa.getContato().setDataCadastro(new Date());

            pessoa.getContato().setPessoa(pessoa);
            pessoa.getContato().setSequencia(resultadoContato.getSequencia() + 1);
        }

        if (resultaEndereco == null) {

            pessoa.getEndereco().setAtivo(true);
//            pessoa.getEndereco().setBairro("Monte das Oliveiras");
            pessoa.getEndereco().setLogradouro("Rua Muiratinga");
            pessoa.getEndereco().setCep("69093-129");
            pessoa.getEndereco().setSequencia(1L);
            pessoa.getEndereco().setComplemento("João teste Complemento");
            pessoa.getEndereco().setDataCadastro(new Date());
            pessoa.getEndereco().setNumero("310");
            pessoa.getEndereco().setPessoa(pessoa);

        } else {

            pessoa.getEndereco().setAtivo(true);
//            pessoa.getEndereco().setBairro("Monte das Oliveiras");
            pessoa.getEndereco().setLogradouro("Rua Muiratinga");
            pessoa.getEndereco().setCep("69093-129");
            pessoa.getEndereco().setSequencia(resultaEndereco.getSequencia() + 1);
            pessoa.getEndereco().setComplemento("João teste Complemento");
            pessoa.getEndereco().setDataCadastro(new Date());
            pessoa.getEndereco().setNumero("310");
            pessoa.getEndereco().setPessoa(pessoa);
        }
        //enderecoDAO.merge(endereco);

        if (resultadoDocumento == null) {
            pessoa.getDocumento().setDataCadastro(new Date());
            pessoa.getDocumento().setDescricao("405.076.621-30");
            pessoa.getDocumento().setPessoa(pessoa);
            pessoa.getDocumento().setSequencia(1);
        } else {
            pessoa.getDocumento().setDataCadastro(new Date());
            pessoa.getDocumento().setDescricao("405.076.621-30");
            pessoa.getDocumento().setPessoa(pessoa);
            pessoa.getDocumento().setSequencia(resultadoDocumento.getSequencia() + 1);
        }
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario resultadoFuncionario = (Funcionario) funcionarioDAO.listarSequencia();

        if (resultadoFuncionario == null) {
            funcionario.setDataCadastro(new Date());
            funcionario.setPessoa(pessoa);
            funcionario.setSequencia(1);
            funcionario.setDataAdmissao(new Date());
            funcionario.setTipoFuncionario(tipoFuncionario);
        } else {
            funcionario.setDataCadastro(new Date());
            funcionario.setPessoa(pessoa);
            funcionario.setSequencia(resultadoFuncionario.getSequencia() + 1);
            funcionario.setDataAdmissao(new Date());
            funcionario.setTipoFuncionario(tipoFuncionario);
        }

        funcionarioDAO.merge(funcionario);
    }

    @Test
    @Ignore
    public void listar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> resultado = clienteDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Cliente cliente : resultado) {
            System.out.println(cliente.getCodigo() + " - " + cliente.getPessoa().getNome());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscar(1L);

        if (cliente == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(cliente.getCodigo() + " - " + cliente.getPessoa().getNome() + "Data Nascimento: " + cliente.getPessoa().getDataCadastro());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 3L;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscar(codigo);

        if (cliente == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            clienteDAO.excluir(cliente);
            System.out.println("Registro removido:");
            System.out.println(cliente.getCodigo() + " - " + cliente.getPessoa().getNome());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscar(codigo);

        if (cliente == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(cliente.getCodigo() + " - " + cliente.getPessoa().getNome());

            cliente.setDataCadastro(new Date());

            System.out.println("Registro editado - Depois:");
            System.out.println(cliente.getCodigo() + " - " + cliente.getDataCadastro());
        }
    }

}
