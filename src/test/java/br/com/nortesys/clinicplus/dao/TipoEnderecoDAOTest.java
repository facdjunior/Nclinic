package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoEndereco;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class TipoEnderecoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        TipoEndereco tipoEndereco = new TipoEndereco();

        tipoEndereco.setAtivo(true);
        tipoEndereco.setDataCadastro(new Date());
        tipoEndereco.setDescricao("ENDEREÇO PARA COBRANÇA");
        tipoEndereco.setSequencia(3L);

        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        tipoEnderecoDAO.merge(tipoEndereco);

    }

    @Test
    @Ignore
    public void listar() {

        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        List<TipoEndereco> resultado = tipoEnderecoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoEndereco tipoEndereco : resultado) {
            System.out.println(tipoEndereco.getCodigo() + " - " + tipoEndereco.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {

        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        TipoEndereco tipoEndereco = tipoEnderecoDAO.buscar(1L);

        if (tipoEndereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(tipoEndereco.getCodigo() + " - " + tipoEndereco.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        TipoEndereco tipoEndereco = tipoEnderecoDAO.buscar(codigo);

        if (tipoEndereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoEnderecoDAO.excluir(tipoEndereco);
            System.out.println("Registro removido:");
            System.out.println(tipoEndereco.getCodigo() + " - " + tipoEndereco.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoEnderecoDAO tipoEnderecoDAO = new TipoEnderecoDAO();
        TipoEndereco tipoEndereco = tipoEnderecoDAO.buscar(codigo);

        if (tipoEndereco == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(tipoEndereco.getCodigo() + " - " + tipoEndereco.getDescricao());

            tipoEndereco.setAtivo(true);
            tipoEndereco.setDataCadastro(new Date());
            tipoEndereco.setDescricao("ENDERECO RESIDENCIAL");
            tipoEnderecoDAO.merge(tipoEndereco);

            System.out.println("Registro editado - Depois:");
            System.out.println(tipoEndereco.getCodigo() + " - " + tipoEndereco.getDescricao());
        }
    }
}
