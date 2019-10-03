package br.com.nortesys.clinicplus.dao.financeiro;

import br.com.nortesys.clinicplus.dao.ModalidadeLancamentoDAO;
import br.com.nortesys.clinicplus.dao.TipoLancamentoDAO;
import br.com.nortesys.clinicplus.domain.financeiro.ModalidadeLancamento;
import br.com.nortesys.clinicplus.domain.financeiro.TipoLancamentos;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class TipoLancamentoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        Long codigo = 2L;

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos ResultadotpLancamento = tipoLancamentoDAO.listarSequencia();

        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        ModalidadeLancamento ml = modalidadeLancamentoDAO.buscar(codigo);

        TipoLancamentos tipoLancamento = new TipoLancamentos();

        if (ResultadotpLancamento == null) {

            tipoLancamento.setSequencia(1L);
            tipoLancamento.setDataCadastro(new Date());
            tipoLancamento.setDescricao("Alimentação");
            tipoLancamento.setModalidadeLancamento(ml);

        } else {

            tipoLancamento.setSequencia(ResultadotpLancamento.getSequencia() + 1);
            tipoLancamento.setDataCadastro(new Date());
            tipoLancamento.setDescricao("Aluguel");
            tipoLancamento.setModalidadeLancamento(ml);
        }

        tipoLancamentoDAO.merge(tipoLancamento);

    }

    @Test
    @Ignore
    public void listar() {

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        List<TipoLancamentos> resultado = tipoLancamentoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoLancamentos tipoLancamento : resultado) {
            System.out.println(tipoLancamento.getCodigo() + " - " + tipoLancamento.getDescricao());
        }

    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 1L;

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos tipoLancamento = tipoLancamentoDAO.buscar(1L);

        if (tipoLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(tipoLancamento.getCodigo() + " - " + tipoLancamento.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos tipoLancamento = tipoLancamentoDAO.buscar(codigo);

        if (tipoLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoLancamentoDAO.excluir(tipoLancamento);
            System.out.println("Registro removido:");
            System.out.println(tipoLancamento.getCodigo() + " - " + tipoLancamento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos tipoLancamento = tipoLancamentoDAO.buscar(codigo);

        if (tipoLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(tipoLancamento.getCodigo() + " - " + tipoLancamento.getDescricao());

            tipoLancamento.setDescricao("Alimentação");
            tipoLancamento.setDataCadastro(new Date());
            tipoLancamentoDAO.merge(tipoLancamento);

            System.out.println("Registro editado - Depois:");
            System.out.println(tipoLancamento.getCodigo() + " - " + tipoLancamento.getDescricao());
        }
    }
}
