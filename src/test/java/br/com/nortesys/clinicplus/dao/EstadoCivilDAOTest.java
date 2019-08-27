package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.EstadoCivil;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Junior
 */
public class EstadoCivilDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
//            estadoCivilDAO.sequencia();
            EstadoCivil estadoCivil = new EstadoCivil();

            if (estadoCivil.getSequencia() == null) {
  //              estadoCivil.setSequencia(estadoCivilDAO.sequencia().getSequencia() + 1);
                
                estadoCivil.setDescricao("Viuvo");
                estadoCivil.setDataCadastro(new Date());

                estadoCivilDAO.merge(estadoCivil);
                return;
            }
            estadoCivil.setSequencia(estadoCivil.getSequencia() + 1);
            estadoCivil.setDescricao("Viuvo");
            estadoCivil.setDataCadastro(new Date());

            estadoCivilDAO.merge(estadoCivil);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }

    }

    @Test
    @Ignore
    public void listar() {
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> resultado = estadoCivilDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (EstadoCivil estadoCivil : resultado) {
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }

 /*   @Test
    @Ignore
    public void sequencia() {
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.sequencia();

        //int estoqueAtual = produto.getQuantidade() - itemVenda.getQuantidade();
        if (estadoCivil.getSequencia() == null) {
            int Maximo = 0;
            estadoCivil.setSequencia(Maximo + 1);

            System.out.println(+estadoCivil.getCodigo() + "-" + estadoCivil.getSequencia());
            return;
        }

        estadoCivil.setSequencia(estadoCivil.getSequencia() + 1);
        System.out.println("Passou: " + estadoCivil.getCodigo() + "--" + estadoCivil.getSequencia());
    }*/

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            estadoCivilDAO.excluir(estadoCivil);
            System.out.println("Registro removido:");
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());

            estadoCivil.setDescricao("Casado");
            estadoCivil.setDataCadastro(new Date());
            estadoCivilDAO.merge(estadoCivil);

            System.out.println("Registro editado - Depois:");
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }
}
