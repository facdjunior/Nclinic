package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
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
public class ClienteDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

        PessoaFisica resultadoPFisica = (PessoaFisica) pessoaFisicaDAO.listarSequencia();

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(1L);
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
            pessoa.setPessoaFisica(pessoaFisica);

            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Bento Felipe Yago Figueiredo");
            pessoa.setDataCadastro(new Date());
            pessoa.setPessoaFisica(pessoaFisica);

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

            contato.setCelular("(92)98395-0668");
            contato.setDataCadastro(new Date());
            contato.setFone("(92)3906-2716");
            //   contato.setPessoa(pessoa);
            contato.setSequencia(1L);

        } else {
            contato.setCelular("(92)98395-0668");
            contato.setDataCadastro(new Date());
            contato.setFone("(92)3906-2716");
            //        contato.setPessoa(pessoa);
            contato.setSequencia(resultadoContato.getSequencia() + 1);
        }

        pessoaDAO.merge(pessoa);
        contatoDAO.merge(contato);

        if (resultaEndereco == null) {

            endereco.setAtivo(true);
            endereco.setBairro("Monte das Oliveiras");
            endereco.setLogadouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(1L);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");
            
            endereco.setPessoa(pessoa);

        } else {

            endereco.setAtivo(true);
            endereco.setBairro("Monte das Oliveiras");
            endereco.setLogradouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(resultaEndereco.getSequencia() + 1);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");
            
            endereco.setPessoa(pessoa);
        }
        enderecoDAO.merge(endereco);

        if (resultadoDocumento == null) {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            // documento.setPessoa(pessoa);
            documento.setSequencia(1);
        } else {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            // documento.setPessoa(pessoa);
            documento.setSequencia(resultadoDocumento.getSequencia() + 1);
        }
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente resultadoCliente = (Cliente) clienteDAO.listarSequencia();

        if (resultadoCliente == null) {
            cliente.setDataCadastro(new Date());
            cliente.setPessoa(pessoa);
            cliente.setSequencia(1);
        } else {
            cliente.setDataCadastro(new Date());
            cliente.setPessoa(pessoa);
            cliente.setSequencia(resultadoCliente.getSequencia() + 1);
        }
        clienteDAO.merge(cliente);
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
            System.out.println(cliente.getCodigo() + " - " + cliente.getPessoa().getNome() + "Data Nascimento: " + cliente.getPessoa().getPessoaFisica().getDataNascimento());
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
