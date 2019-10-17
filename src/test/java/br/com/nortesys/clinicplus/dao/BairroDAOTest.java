package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Bairro;
import br.com.nortesys.clinicplus.domain.Cidade;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class BairroDAOTest {

    @Test
    @Ignore
    public void salvar() {

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(1L);

        Bairro bairro = new Bairro();

        bairro.setAtivo(true);
        bairro.setCidade(cidade);
        bairro.setDataCadastro(new Date());
        bairro.setDescricao("Centro");

        BairroDAO bairroDAO = new BairroDAO();

        bairroDAO.merge(bairro);

    }

    @Test
    @Ignore
    public void listar() {
        BairroDAO bairroDAO = new BairroDAO();
        List<Bairro> resultado = bairroDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Bairro bairro : resultado) {
            System.out.println(bairro.getCodigo() + " - " +bairro.getCidade().getDescricao()+ "-" + bairro.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(1L);

        if (bairro == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigo);

        if (bairro == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            bairroDAO.excluir(bairro);
            System.out.println("Registro removido:");
            System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigo);

        if (bairro == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());

            bairro.setDescricao("CENTRO");
            bairro.setDataCadastro(new Date());
            bairroDAO.merge(bairro);

            System.out.println("Registro editado - Depois:");
            System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());
        }
    }
}
