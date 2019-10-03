package br.com.nortesys.clinicplus.dao.financeiro;

import br.com.nortesys.clinicplus.dao.CaixaDAO;
import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class CaixaDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            CaixaDAO caixaDAO = new CaixaDAO();
            Caixa resultado = (Caixa) caixaDAO.listarSequencia();
            
            Caixa caixa = new Caixa();
            

            if (resultado == null) {
                caixa.setSequencia(1L);
                caixa.setAtivo(true);
                caixa.setDataCadastro(new Date());
                caixa.setDescricao("Caixa 001");
                caixa.setNumeroCaixa("001");
            } else {
                caixa.setSequencia(resultado.getSequencia() + 1);
                caixa.setAtivo(true);
                caixa.setDataCadastro(new Date());
                caixa.setDescricao("Caixa 003");
                caixa.setNumeroCaixa("003");
            }

            caixaDAO.merge(caixa);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }

    }

    @Test
    @Ignore
    public void listar() {
        CaixaDAO caixaDAO = new CaixaDAO();
        List<Caixa> resultado = caixaDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Caixa caixa : resultado) {
            System.out.println(caixa.getCodigo() + " - " + caixa.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = caixaDAO.buscar(1L);

        if (caixa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrados:");
            System.out.println(caixa.getCodigo() + " - " + caixa.getDescricao());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 3L;
        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = caixaDAO.buscar(codigo);

        if (caixa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            caixaDAO.excluir(caixa);
            System.out.println("Registro removido:");
            System.out.println(caixa.getCodigo() + " - " + caixa.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 2L;
        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = caixaDAO.buscar(codigo);

        if (caixa == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(caixa.getCodigo() + " - " + caixa.getDescricao());

            caixa.setDescricao("Caixa 002");
            caixa.setDataCadastro(new Date());
            caixaDAO.merge(caixa);

            System.out.println("Registro editado - Depois:");
            System.out.println(caixa.getCodigo() + " - " + caixa.getDescricao());
        }
    }

}
