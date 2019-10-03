package br.com.nortesys.clinicplus.dao.financeiro;

import br.com.nortesys.clinicplus.dao.CaixaDAO;
import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import br.com.nortesys.clinicplus.domain.financeiro.CaixaAberturaFechamento;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class CaixaAberturaFechamentoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            CaixaDAO caixaDAODAO = new CaixaDAO();
            Caixa caixa = caixaDAODAO.buscar(2L);

            CaixaAberturaFechamentoDAO aberturaFechamentoDAO = new CaixaAberturaFechamentoDAO();
            CaixaAberturaFechamento aberturaFechamento = new CaixaAberturaFechamento();

            CaixaAberturaFechamento resultado = (CaixaAberturaFechamento) aberturaFechamentoDAO.listarSequencia();

            if (resultado == null) {
                
                aberturaFechamento.setSequencia(1L);
                aberturaFechamento.setDataCadastro(new Date());
                aberturaFechamento.setAbertura(new Date());
                aberturaFechamento.setAtivo(true);
                aberturaFechamento.setCaixa(caixa);
                aberturaFechamento.setSaldoAbertura(new BigDecimal("1.00"));

                aberturaFechamentoDAO.merge(aberturaFechamento);

            } else {
                aberturaFechamento.setSequencia(resultado.getSequencia() + 1L);
                aberturaFechamento.setDataCadastro(new Date());
                aberturaFechamento.setAbertura(new Date());
                aberturaFechamento.setAtivo(true);
                aberturaFechamento.setCaixa(caixa);
                aberturaFechamento.setSaldoAbertura(new BigDecimal("1.00"));
                

            }

            aberturaFechamentoDAO.merge(aberturaFechamento);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }

    }

    @Test
    @Ignore
    public void listar() {
        CaixaAberturaFechamentoDAO aberturaFechamentoDAO = new CaixaAberturaFechamentoDAO();
        List<CaixaAberturaFechamento> resultado = aberturaFechamentoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (CaixaAberturaFechamento aberturaFechamento : resultado) {
            System.out.println(aberturaFechamento.getCodigo() + " - " + aberturaFechamento.getCaixa().getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        CaixaAberturaFechamentoDAO aberturaFechamentoDAO = new CaixaAberturaFechamentoDAO();
        CaixaAberturaFechamento aberturaFechamento = aberturaFechamentoDAO.buscar(1L);

        if (aberturaFechamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(aberturaFechamento.getCodigo() + " - " + aberturaFechamento.getCaixa().getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        CaixaAberturaFechamentoDAO aberturaFechamentoDAO = new CaixaAberturaFechamentoDAO();
        CaixaAberturaFechamento aberturaFechamento = aberturaFechamentoDAO.buscar(codigo);

        if (aberturaFechamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            aberturaFechamentoDAO.excluir(aberturaFechamento);
            System.out.println("Registro removido:");
            System.out.println(aberturaFechamento.getCodigo() + " - " + aberturaFechamento.getCaixa().getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        
        Long codigo = 1L;
        CaixaAberturaFechamentoDAO aberturaFechamentoDAO = new CaixaAberturaFechamentoDAO();
        CaixaAberturaFechamento aberturaFechamento = aberturaFechamentoDAO.buscar(codigo);

        if (aberturaFechamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(aberturaFechamento.getCodigo() + " - " + aberturaFechamento.getCaixa().getDescricao());

            aberturaFechamento.setDataFechamento(new Date());
            aberturaFechamento.setTotalEmCaixa(new BigDecimal("1.00"));
            aberturaFechamento.setValorDiferença(new BigDecimal("0.00"));

            aberturaFechamentoDAO.merge(aberturaFechamento);

            System.out.println("Registro editado - Depois:");
            System.out.println(aberturaFechamento.getCodigo() + " - " + aberturaFechamento.getCaixa().getDescricao());
        }
    }
}
