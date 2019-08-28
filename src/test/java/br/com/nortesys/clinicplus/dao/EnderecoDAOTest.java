package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.Pessoa;
import java.util.Date;
import java.util.List;
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
        Pessoa pessoa = pessoaDAO.buscar(21L);

        Endereco endereco = new Endereco();

        endereco.setAtivo(true);
        endereco.setBairro("Porto Novo");
        endereco.setDescricao("Rua Mato Grosso I");
        endereco.setCEP("29155-430");
        endereco.setSequencia(5L);
        endereco.setComplemento("João teste Complemento");
        endereco.setDataCadastro(new Date());
        endereco.setNumero("561");
        endereco.setObservacao("Cariacica");

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.merge(endereco);

    }

    @Test
    @Ignore
    public void listar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Endereco endereco : resultado) {
            System.out.println(endereco.getCodigo() + " - " + endereco.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscar(1L);

        if (endereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(endereco.getCodigo() + " - " + endereco.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscar(codigo);

        if (endereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            enderecoDAO.excluir(endereco);
            System.out.println("Registro removido:");
            System.out.println(endereco.getCodigo() + " - " + endereco.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscar(codigo);

        if (endereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(endereco.getCodigo() + " - " + endereco.getDescricao());

            endereco.setDescricao("Rua João de Sousa Lima");
            endereco.setDataCadastro(new Date());
            enderecoDAO.merge(endereco);

            System.out.println("Registro editado - Depois:");
            System.out.println(endereco.getCodigo() + " - " + endereco.getDescricao());
        }
    }
}
