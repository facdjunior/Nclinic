package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.UF;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class UfDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            UfDAO ufDAO = new UfDAO();

            UF uf = new UF();
            UF resultado = (UF) ufDAO.listarSequencia();
            
            

            if (resultado == null) {
                uf.setCodigo(1L +resultado.getCodigo());
                uf.setSequencia(1l);
                uf.setDescricao("Pará");
                uf.setUF("PA");
                uf.setDataCadastro(new Date());

                ufDAO.merge(uf);
                return;
            }
            uf.setCodigo(1L +resultado.getCodigo());
            uf.setSequencia(resultado.getSequencia() + 1L);
            uf.setDescricao("TOCANTINS");
            uf.setUF("TO");
            uf.setCodigoTISS_UF("17");
            uf.setDataCadastro(new Date());

            // uf.setPessoa(pessoa);
            ufDAO.merge(uf);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }

    @Test
    @Ignore
    public void listar() {
        UfDAO ufDAO = new UfDAO();
        List<UF> resultado = ufDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (UF uf : resultado) {
            System.out.println(uf.getCodigo() + " - " + uf.getDescricao());
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
        UfDAO ufDAO = new UfDAO();
        UF uf = ufDAO.buscar(codigo);

        if (uf == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            ufDAO.excluir(uf);
            System.out.println("Registro removido:");
            System.out.println(uf.getCodigo() + " - " + uf.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        
        UfDAO ufDAO = new UfDAO();
        UF uf = ufDAO.buscar(codigo);
        
        if (uf == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(uf.getCodigo() + " - " + uf.getCodigo());

            uf.setDataCadastro(new Date());
            ufDAO.merge(uf);

            System.out.println("Registro editado - Depois:");
            System.out.println(uf.getCodigo() + " - " + uf.getDescricao());
        }
    }

}
