package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Empresa;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ConvenioDAOTest {

    @Test
    //@Ignore
    public void salvar() {
        try {

            ConvenioDAO convenioDAO = new ConvenioDAO();
            Convenio convenio = new Convenio();
            EmpresaDAO empresaDAO = new EmpresaDAO();
            Empresa empresa = empresaDAO.buscar(1L);

            Convenio resultado = (Convenio) convenioDAO.listarSequencia();

            if (resultado == null) {
                
                convenio.setSequencia(1);
                convenio.setDescricao("UNIMED");
                convenio.setEmpresa(empresa);
                convenio.setDataCadastro(new Date());

                convenioDAO.merge(convenio);
                return;
            }
            convenio.setSequencia(resultado.getSequencia() + 1);
            convenio.setDescricao("CAP SAUDE");
            convenio.setDataCadastro(new Date());

            convenioDAO.merge(convenio);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }

    }

    @Test
    @Ignore
    public void listar() {
        ConvenioDAO convenioDAO = new ConvenioDAO();
        List<Convenio> resultado = convenioDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Convenio convenio : resultado) {
            System.out.println(convenio.getCodigo() + " - " + convenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio convenio = convenioDAO.buscar(1L);

        if (convenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(convenio.getCodigo() + " - " + convenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio convenio = convenioDAO.buscar(codigo);

        if (convenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            convenioDAO.excluir(convenio);
            System.out.println("Registro removido:");
            System.out.println(convenio.getCodigo() + " - " + convenio.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio convenio = convenioDAO.buscar(codigo);

        if (convenio == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(convenio.getCodigo() + " - " + convenio.getDescricao());

            convenio.setDescricao("UNIMED INTER CAMBIO");
            convenio.setDataCadastro(new Date());
            convenioDAO.merge(convenio);

            System.out.println("Registro editado - Depois:");
            System.out.println(convenio.getCodigo() + " - " + convenio.getDescricao());
        }
    }

}
