package br.com.nortesys.clinicplus.dao;


import br.com.nortesys.clinicplus.domain.Pessoa;
import java.text.ParseException;
import java.util.Date;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class PessoaDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa resultadoPessoa = (Pessoa) pessoaDAO.listarSequencia();

        if (resultadoPessoa == null) {

            pessoa.setNome("Mariana Eliane Fogaça");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);

            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Mariana Eliane Fogaça");
            pessoa.setDataCadastro(new Date());

        }

        pessoaDAO.salvar(pessoa);

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
