package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Profissao;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ProfissaoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = new Profissao();

        try {

            Profissao resultado = (Profissao) profissaoDAO.listarSequencia();

            if (resultado == null) {
                profissao.setSequencia(1);
                profissao.setDataCadastro(new Date());
                profissao.setDescricao("Governador");
                profissao.setCBO("111900");
                profissaoDAO.merge(profissao);

                System.out.println("Registro Salvo com Sucesso!");
                return;
            }

            profissao.setSequencia(resultado.getSequencia() + 1);
            profissao.setDataCadastro(new Date());
            profissao.setDescricao("Sargento da policia militar");
            profissao.setCBO("21110");
            profissaoDAO.merge(profissao);

            System.out.println("Foi para sequencia");
            //               return;

        } catch (RuntimeException e) {
            System.out.println("Erro ao gravar Registro" + e);
        }
    }

    @Test
    @Ignore
    public void listar() {
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        List<Profissao> resultado = profissaoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Profissao profissao : resultado) {
            System.out.println(profissao.getCodigo() + " - " + profissao.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = profissaoDAO.buscar(1L);

        if (profissao == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(profissao.getCodigo() + " - " + profissao.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = profissaoDAO.buscar(codigo);

        if (profissao == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            profissaoDAO.excluir(profissao);
            System.out.println("Registro removido:");
            System.out.println(profissao.getCodigo() + " - " + profissao.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = profissaoDAO.buscar(codigo);

        if (profissao == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(profissao.getCodigo() + " - " + profissao.getDescricao());

            profissao.setDescricao("Sargento da policia militar");
            profissao.setDataCadastro(new Date());
            profissao.setCBO("21110");
            profissaoDAO.merge(profissao);

            System.out.println("Registro editado - Depois:");
            System.out.println(profissao.getCodigo() + " - " + profissao.getDescricao());
        }
    }
}
