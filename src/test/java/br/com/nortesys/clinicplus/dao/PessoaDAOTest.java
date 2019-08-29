package br.com.nortesys.clinicplus.dao;

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
public class PessoaDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

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

            pessoa.setNome("Isaac Nelson Ian Sales");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);
            pessoa.setPessoaFisica(pessoaFisica);

            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Isaac Nelson Ian Sales");
            pessoa.setDataCadastro(new Date());
            pessoa.setPessoaFisica(pessoaFisica);

        }
        if (resultadoPFisica == null) {

            String data = "19/10/1973";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Araguaína");
            pessoaFisica.setSequencia(1);
            pessoaFisica.setSexo('F');
        } else {

            String data = "19/10/1973";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Araguaína");
            pessoaFisica.setSequencia(resultadoPFisica.getSequencia() + 1);
            pessoaFisica.setSexo('M');
        }

        if (resultadoDocumento == null) {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            documento.setPessoa(pessoa);
            documento.setSequencia(1);
        } else {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            documento.setPessoa(pessoa);
            documento.setSequencia(resultadoDocumento.getSequencia() + 1);
        }

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

        if (resultadoContato == null) {

            contato.setCelular("(63)99767-4649");
            contato.setDataCadastro(new Date());
            contato.setFone("(63)2615-6942");
            contato.setPessoa(pessoa);
            contato.setSequencia(1L);

        } else {
            contato.setCelular("(63)99767-4649");
            contato.setDataCadastro(new Date());
            contato.setFone("(63)2615-6942");
            contato.setPessoa(pessoa);
            contato.setSequencia(resultadoContato.getSequencia() + 1);
        }

        pessoaDAO.salvar(pessoa);
        contatoDAO.merge(contato);
        documentoDAO.merge(documento);
        if (resultaEndereco == null) {

            endereco.setAtivo(true);
            endereco.setBairro("Vila Norte");
            endereco.setDescricao("Rua 12");
            endereco.setCEP("77818-280");
            endereco.setSequencia(1L);
            endereco.setComplemento("Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("179");
            endereco.setObservacao("Manaus");
            endereco.setPessoa(pessoa);

        } else {

            endereco.setAtivo(true);
            endereco.setBairro("Vila Norte");
            endereco.setDescricao("Rua 12");
            endereco.setCEP("77818-280");
            endereco.setSequencia(1L);
            endereco.setComplemento("Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("179");
            endereco.setObservacao("Obs");
            endereco.setPessoa(pessoa);
        }
        enderecoDAO.merge(endereco);
    }

    @Test
    @Ignore
    public void listar() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> resultado = pessoaDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Pessoa pessoa : resultado) {
            System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome());
        }
    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(3L);

        if (pessoa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome());
        }
    }
    
    @Test
    @Ignore
    public void excluir() {
        Long codigo = 3L;
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(codigo);

        if (pessoa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            pessoaDAO.excluir(pessoa);
            System.out.println("Registro removido:");
            System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 3L;
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(codigo);

        if (pessoa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome());

            pessoa.setNome("Isaac Nelson Ian Sales Filho");
            pessoa.setDataCadastro(new Date());
            pessoaDAO.merge(pessoa);

            System.out.println("Registro editado - Depois:");
            System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome());
        }
    }
}
