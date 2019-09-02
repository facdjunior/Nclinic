package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.TipoDocumento;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class TipoDocumentoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
            TipoDocumento tipoDocumento = new TipoDocumento();

            TipoDocumento resultado = (TipoDocumento) tipoDocumentoDAO.listarSequencia();

            if (resultado == null) {
                tipoDocumento.setSequencia(1l);
                tipoDocumento.setDescricao("RG");
                tipoDocumento.setAtivo(true);
                tipoDocumento.setTipo("RG");
                tipoDocumento.setDataCadastro(new Date());

                tipoDocumentoDAO.merge(tipoDocumento);
                return;
            }
            tipoDocumento.setSequencia(resultado.getSequencia() + 1);
            tipoDocumento.setDescricao("Número de matrícula");
            tipoDocumento.setAtivo(true);
            tipoDocumento.setTipo("Número de matrícula");
            tipoDocumento.setDataCadastro(new Date());

            tipoDocumentoDAO.merge(tipoDocumento);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }

    }

    @Test
    @Ignore
    public void listar() {
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        List<TipoDocumento> resultado = tipoDocumentoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoDocumento tipoDocumento : resultado) {
            System.out.println(tipoDocumento.getCodigo() + " - " + tipoDocumento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(3L);

        if (tipoDocumento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(tipoDocumento.getCodigo() + " - " + tipoDocumento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(codigo);

        if (tipoDocumento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoDocumentoDAO.excluir(tipoDocumento);
            System.out.println("Registro removido:");
            System.out.println(tipoDocumento.getCodigo() + " - " + tipoDocumento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(codigo);

        if (tipoDocumento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(tipoDocumento.getCodigo() + " - " + tipoDocumento.getDescricao());

            tipoDocumento.setDescricao("UNIMED INTER CAMBIO");
            tipoDocumento.setDataCadastro(new Date());
            tipoDocumentoDAO.merge(tipoDocumento);

            System.out.println("Registro editado - Depois:");
            System.out.println(tipoDocumento.getCodigo() + " - " + tipoDocumento.getDescricao());
        }
    }

}
