package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.TipoConvenio;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class TipoConvenioDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
            TipoConvenio tipoConvenio = new TipoConvenio();

            ConvenioDAO convenioDAO = new ConvenioDAO();
            Convenio convenio = convenioDAO.buscar(1L);

            TipoConvenio resultado = (TipoConvenio) tipoConvenioDAO.listarSequencia();

            if (resultado == null) {

                tipoConvenio.setSequencia(1);
                tipoConvenio.setDescricao("UNIMED");
                tipoConvenio.setDataCadastro(new Date());
                tipoConvenio.setConvenio(convenio);
                tipoConvenio.setAtivo(true);
                tipoConvenio.setELimitarAtendimentoPorDia(false);

                tipoConvenioDAO.merge(tipoConvenio);
                return;
            }
            tipoConvenio.setSequencia(resultado.getSequencia() + 1);
            tipoConvenio.setDescricao("UNIMED");
            tipoConvenio.setDataCadastro(new Date());
            tipoConvenio.setConvenio(convenio);
            tipoConvenio.setAtivo(true);
            tipoConvenio.setELimitarAtendimentoPorDia(false);

            tipoConvenioDAO.merge(tipoConvenio);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }
    
    @Test
    @Ignore
    public void listar() {
        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        List<TipoConvenio> resultado = tipoConvenioDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoConvenio tipoConvenio : resultado) {
            System.out.println(tipoConvenio.getCodigo() + " - " + tipoConvenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        TipoConvenio tipoConvenio = tipoConvenioDAO.buscar(1L);

        if (tipoConvenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(tipoConvenio.getCodigo() + " - " + tipoConvenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        TipoConvenio tipoConvenio = tipoConvenioDAO.buscar(codigo);

        if (tipoConvenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoConvenioDAO.excluir(tipoConvenio);
            System.out.println("Registro removido:");
            System.out.println(tipoConvenio.getCodigo() + " - " + tipoConvenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        TipoConvenio tipoConvenio = tipoConvenioDAO.buscar(codigo);

        if (tipoConvenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(tipoConvenio.getCodigo() + " - " + tipoConvenio.getDescricao());

            tipoConvenio.setDescricao("UNIMED-NACIONAL");
            tipoConvenio.setDataCadastro(new Date());
            tipoConvenioDAO.merge(tipoConvenio);

            System.out.println("Registro editado - Depois:");
            System.out.println(tipoConvenio.getCodigo() + " - " + tipoConvenio.getDescricao());
        }
    }
}
