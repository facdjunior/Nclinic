package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Procedimento;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
import br.com.nortesys.clinicplus.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ProcedimentoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            Procedimento procedimento = new Procedimento();

            Procedimento resultado = (Procedimento) procedimentoDAO.listarSequencia();

            if (resultado == null) {

                procedimento.setSequencia(1L);
                procedimento.setDescricao("Orçamento");
                procedimento.setDataCadastro(new Date());
                procedimento.setESessao(false);
                procedimento.setAtivo(true);
                procedimento.setEProdutoKit(false);
                procedimento.setNumeracaoProcedimento("");
                procedimento.setNumeracaoTuss("");
                procedimento.setEExame(false);
                procedimento.setMensagemSMS("");
                procedimento.setMensagemEmail("");
                procedimento.setQuantidadeDiasEnviarMensagemMarketing(null);
                procedimento.setELaudo(true);
                procedimento.setEAtestado(true);

            } else {

                procedimento.setSequencia(resultado.getSequencia() + 1L);
                procedimento.setDescricao("PCCU (citologia oncotica) 48 hrs");
                procedimento.setDataCadastro(new Date());
                procedimento.setESessao(false);
                procedimento.setAtivo(true);
                procedimento.setEProdutoKit(false);
                procedimento.setNumeracaoProcedimento("");
                procedimento.setNumeracaoTuss("");
                procedimento.setDataAtualizacao(new Date());
                procedimento.setEExame(false);
                procedimento.setMensagemSMS("");
                procedimento.setMensagemEmail("");
                procedimento.setQuantidadeDiasEnviarMensagemMarketing(null);
                procedimento.setELaudo(true);
                procedimento.setEAtestado(true);

            }

            procedimentoDAO.merge(procedimento);

            System.out.println("Registro salvo com sucesso");

        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }

    @Test
    @Ignore
    public void listar() {
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        List<Procedimento> resultado = procedimentoDAO.listar("Descricao");

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Procedimento procedimento : resultado) {
            System.out.println(procedimento.getCodigo() + " - " + procedimento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        Procedimento procedimento = procedimentoDAO.buscar(1L);

        if (procedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(procedimento.getCodigo() + " - " + procedimento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 1L;
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        Procedimento procedimento = procedimentoDAO.buscar(codigo);

        if (procedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            procedimentoDAO.excluir(procedimento);
            System.out.println("Registro removido:");
            System.out.println(procedimento.getCodigo() + " - " + procedimento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 3L;
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        Procedimento procedimento = procedimentoDAO.buscar(codigo);

        if (procedimento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(procedimento.getCodigo() + " - " + procedimento.getDescricao());

            procedimento.setESessao(false);
            procedimento.setAtivo(true);
            procedimento.setEProdutoKit(false);
            procedimento.setDataAtualizacao(new Date());
            procedimento.setEExame(false);
            procedimento.setMensagemSMS("");
            procedimento.setMensagemEmail("");
            procedimento.setQuantidadeDiasEnviarMensagemMarketing(null);
            procedimento.setELaudo(true);
            procedimento.setEAtestado(true);

            procedimentoDAO.merge(procedimento);
            System.out.println("Registro editado - Depois:");
            System.out.println(procedimento.getCodigo() + " - " + procedimento.getDescricao());
        }
    }

}
