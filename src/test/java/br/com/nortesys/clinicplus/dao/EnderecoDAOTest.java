package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Bairro;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.TipoEndereco;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class EnderecoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(16L);

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(1L);
        
        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        TipoEndereco tipoEndereco = tipoEnderecoDAO.buscar(1L);

        Endereco endereco = new Endereco();

        endereco.setAtivo(true);
        endereco.setBairro(bairro);
        endereco.setCep("68371-155");
        endereco.setComplemento("entre 264 a 265");
        endereco.setDataCadastro(new Date());
        endereco.setLogradouro("Travessa Pedro Gomes");
        endereco.setNumero("264");
        endereco.setPessoa(pessoa);
        endereco.setSequencia(1L);
        endereco.setTipoEndereco(tipoEndereco);

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
            System.out.println(endereco.getCodigo() + " - " + endereco.getLogradouro());
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
            System.out.println(endereco.getCodigo() + " - " + endereco.getLogradouro());
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
            System.out.println(endereco.getCodigo() + " - " + endereco.getLogradouro());
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
            System.out.println(endereco.getCodigo() + " - " + endereco.getLogradouro());

            endereco.setLogradouro("Rua João de Sousa Lima");
            endereco.setDataCadastro(new Date());
            enderecoDAO.merge(endereco);

            System.out.println("Registro editado - Depois:");
            System.out.println(endereco.getCodigo() + " - " + endereco.getLogradouro());
        }
    }
}
