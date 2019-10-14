package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.ConvenioAssociado;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ConvenioAssociadoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();

            ConvenioAssociado convenioAssociado = new ConvenioAssociado();
            ConvenioAssociado resultado = (ConvenioAssociado) convenioAssociadoDAO.listarSequencia();

            if (resultado == null) {
                convenioAssociado.setSequencia(1l);
                convenioAssociado.setDescricao("Particular");
                convenioAssociado.setECortesia(false);
                convenioAssociado.setDataCadastro(new Date());

                convenioAssociadoDAO.merge(convenioAssociado);
                return;
            }
            convenioAssociado.setSequencia(resultado.getSequencia() + 1);
            convenioAssociado.setDescricao("PRO VIDA");
            convenioAssociado.setECortesia(false);
            convenioAssociado.setDataCadastro(new Date());

            convenioAssociadoDAO.merge(convenioAssociado);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }
    
    @Test
    @Ignore
    public void listar() {
        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        List<ConvenioAssociado> resultado = convenioAssociadoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (ConvenioAssociado convenioAssociado : resultado) {
            System.out.println(convenioAssociado.getCodigo() + " - " + convenioAssociado.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(1L);

        if (convenioAssociado == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(convenioAssociado.getCodigo() + " - " + convenioAssociado.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(codigo);

        if (convenioAssociado == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            convenioAssociadoDAO.excluir(convenioAssociado);
            System.out.println("Registro removido:");
            System.out.println(convenioAssociado.getCodigo() + " - " + convenioAssociado.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(codigo);

        if (convenioAssociado == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(convenioAssociado.getCodigo() + " - " + convenioAssociado.getDescricao());

            convenioAssociado.setDescricao("PARTICULAR");
            convenioAssociado.setDataCadastro(new Date());
            convenioAssociadoDAO.merge(convenioAssociado);

            System.out.println("Registro editado - Depois:");
            System.out.println(convenioAssociado.getCodigo() + " - " + convenioAssociado.getDescricao());
        }
    }
}
