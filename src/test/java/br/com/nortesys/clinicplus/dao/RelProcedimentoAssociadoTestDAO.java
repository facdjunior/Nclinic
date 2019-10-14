package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.ConvenioAssociado;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class RelProcedimentoAssociadoTestDAO {

    @Test
    @Ignore
    public void salvar() {
        try {

            RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
            RelProcedimentoConvenioAssociado relProcedimentoConvenioAssociado = new RelProcedimentoConvenioAssociado();

            RelProcedimentoConvenioAssociado resultado = (RelProcedimentoConvenioAssociado) relProcedimentoConvenioAssociadoDAO.listarSequencia();

            ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
            ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(1L);

            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            Procedimento procedimento = procedimentoDAO.buscar(1L);

            if (resultado == null) {

                relProcedimentoConvenioAssociado.setSequencia(1L);
                relProcedimentoConvenioAssociado.setConvenioAssociado(convenioAssociado);
                relProcedimentoConvenioAssociado.setProcedimento(procedimento);
                relProcedimentoConvenioAssociado.setValor(new BigDecimal(0.00));
                relProcedimentoConvenioAssociado.setDataCadastro(new Date());
                relProcedimentoConvenioAssociado.setEParticular(true);

            } else {

                relProcedimentoConvenioAssociado.setSequencia(1L);
                relProcedimentoConvenioAssociado.setConvenioAssociado(convenioAssociado);
                relProcedimentoConvenioAssociado.setProcedimento(procedimento);
                relProcedimentoConvenioAssociado.setValor(new BigDecimal(0.00));
                relProcedimentoConvenioAssociado.setDataCadastro(new Date());
                relProcedimentoConvenioAssociado.setEParticular(true);
            }

            relProcedimentoConvenioAssociadoDAO.merge(relProcedimentoConvenioAssociado);

            System.out.println("Registro salvo com sucesso");

        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }

    @Test
    @Ignore
    public void listar() {
        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        List<RelProcedimentoConvenioAssociado> resultado = relProcedimentoConvenioAssociadoDAO.listar("codigo");

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (RelProcedimentoConvenioAssociado relProcedimento : resultado) {
            System.out.println(relProcedimento.getCodigo() + " - " + relProcedimento.getProcedimento().getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        RelProcedimentoConvenioAssociado relProcedimento = relProcedimentoConvenioAssociadoDAO.buscar(1L);

        if (relProcedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(relProcedimento.getCodigo() + " - " + relProcedimento.getProcedimento().getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 1L;
        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        RelProcedimentoConvenioAssociado relProcedimento = relProcedimentoConvenioAssociadoDAO.buscar(codigo);

        if (relProcedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            relProcedimentoConvenioAssociadoDAO.excluir(relProcedimento);
            System.out.println("Registro removido:");
            System.out.println(relProcedimento.getCodigo() + " - " + relProcedimento.getProcedimento().getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 3L;
        RelProcedimentoConvenioAssociadoDAO relProcedimentoAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        RelProcedimentoConvenioAssociado relProcedimento = relProcedimentoAssociadoDAO.buscar(codigo);

        if (relProcedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(relProcedimento.getCodigo() + " - " + relProcedimento.getProcedimento().getDescricao());

            relProcedimento.setDataCadastro(new Date());
            
            relProcedimentoAssociadoDAO.merge(relProcedimento);
            System.out.println("Registro editado - Depois:");
            System.out.println(relProcedimento.getCodigo() + " - " + relProcedimento.getProcedimento().getDescricao());
        }
    }

}
