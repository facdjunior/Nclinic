package br.com.nortesys.clinicplus.dao.financeiro;

import br.com.nortesys.clinicplus.dao.ModalidadeLancamentoDAO;
import br.com.nortesys.clinicplus.domain.financeiro.ModalidadeLancamento;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class ModalidadeLancamentoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        ModalidadeLancamento resultadoSequencia = modalidadeLancamentoDAO.listarSequencia();

        ModalidadeLancamento modalidadeLancamento = new ModalidadeLancamento();

        if (resultadoSequencia == null) {
            modalidadeLancamento.setSequencia(1);
            modalidadeLancamento.setDataCadastro(new Date());
            modalidadeLancamento.setDescricao("Despesas");

        } else {
            modalidadeLancamento.setSequencia(resultadoSequencia.getSequencia() + 1);
            modalidadeLancamento.setDataCadastro(new Date());
            modalidadeLancamento.setDescricao("Receitas");
        }

        modalidadeLancamentoDAO.merge(modalidadeLancamento);

    }

    @Test
    @Ignore
    public void listar() {

        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        List<ModalidadeLancamento> resultado = modalidadeLancamentoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (ModalidadeLancamento modalidadeLancamento : resultado) {
            System.out.println(modalidadeLancamento.getCodigo() + " - " + modalidadeLancamento.getDescricao());
        }

    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        ModalidadeLancamento modalidadeLancamento = modalidadeLancamentoDAO.buscar(1L);

        if (modalidadeLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(modalidadeLancamento.getCodigo() + " - " + modalidadeLancamento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void excluir() {
        Long codigo = 3L;
        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        ModalidadeLancamento modalidadeLancamento = modalidadeLancamentoDAO.buscar(codigo);

        if (modalidadeLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            modalidadeLancamentoDAO.excluir(modalidadeLancamento);
            System.out.println("Registro removido:");
            System.out.println(modalidadeLancamento.getCodigo() + " - " + modalidadeLancamento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        ModalidadeLancamento modalidadeLancamento = modalidadeLancamentoDAO.buscar(codigo);

        if (modalidadeLancamento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(modalidadeLancamento.getCodigo() + " - " + modalidadeLancamento.getDescricao());

            modalidadeLancamento.setDescricao("Despesa");
            modalidadeLancamento.setDataCadastro(new Date());
            modalidadeLancamentoDAO.merge(modalidadeLancamento);

            System.out.println("Registro editado - Depois:");
            System.out.println(modalidadeLancamento.getCodigo() + " - " + modalidadeLancamento.getDescricao());
        }
    }
}
