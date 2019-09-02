package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Alves
 */
public class TipoFuncionarioDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            TipoFuncionario tipoFuncionario = new TipoFuncionario();

            TipoFuncionario resultado = (TipoFuncionario) tipoFuncionarioDAO.listarSequencia();

            if (resultado == null) {
                tipoFuncionario.setSequencia(1);
                tipoFuncionario.setDescricao("Auxiliar de Serviços Gerais");
                tipoFuncionario.setDataCadastro(new Date());

                tipoFuncionarioDAO.merge(tipoFuncionario);
                return;
            }
            tipoFuncionario.setSequencia(resultado.getSequencia() + 1);
            tipoFuncionario.setDescricao("Auxiliar Administrativo");
            tipoFuncionario.setDataCadastro(new Date());

            tipoFuncionarioDAO.merge(tipoFuncionario);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }

    }

    @Test
    @Ignore
    public void listar() {
        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        List<TipoFuncionario> resultado = tipoFuncionarioDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoFuncionario tipoFuncionario : resultado) {
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(8L);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 20L;
        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoFuncionarioDAO.excluir(tipoFuncionario);
            System.out.println("Registro removido:");
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 18L;
        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());

            tipoFuncionario.setDescricao("ESTAGIARIO");
            tipoFuncionario.setDataCadastro(new Date());
            tipoFuncionarioDAO.merge(tipoFuncionario);

            System.out.println("Registro editado - Depois:");
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

}
