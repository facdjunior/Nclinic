package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cidade;
import br.com.nortesys.clinicplus.domain.UF;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class CidadeDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            UfDAO ufDAO = new UfDAO();
            UF uf = ufDAO.buscar(1L);

            CidadeDAO cidadeDAO = new CidadeDAO();
            Cidade cidade = new Cidade();
            Cidade resultado = (Cidade) cidadeDAO.listarSequencia();

            if (resultado == null) {
                cidade.setSequencia(1l);
                cidade.setDescricao("Altamira");
                cidade.setUf(uf);
                cidade.setDataCadastro(new Date());

                cidadeDAO.merge(cidade);
                return;
            }

            cidade.setSequencia(resultado.getSequencia() + 1L);
            cidade.setDescricao("Anajás");
            cidade.setUf(uf);
            cidade.setDataCadastro(new Date());

            cidadeDAO.merge(cidade);

            System.out.println("Registro salvo com sucesso");

        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }

    @Test
    @Ignore
    public void listar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Cidade cidade : resultado) {
            System.out.println(cidade.getCodigo() + " - " + cidade.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        UfDAO ufDAO = new UfDAO();
        UF uf = ufDAO.buscar(2L);

        if (uf == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(uf.getCodigo() + " - " + uf.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(codigo);

        if (cidade == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            cidadeDAO.excluir(cidade);
            System.out.println("Registro removido:");
            System.out.println(cidade.getCodigo() + " - " + cidade.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(codigo);

        if (cidade == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(cidade.getCodigo() + " - " + cidade.getCodigo());

            cidade.setDataCadastro(new Date());
            cidadeDAO.merge(cidade);

            System.out.println("Registro editado - Depois:");
            System.out.println(cidade.getCodigo() + " - " + cidade.getDescricao());
        }
    }

}
