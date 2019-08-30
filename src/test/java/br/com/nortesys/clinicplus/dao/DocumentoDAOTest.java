package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Pessoa;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior 2019_08_28
 */
public class DocumentoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            DocumentoDAO documentoDAO = new DocumentoDAO();
            Documento documento = new Documento();

            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa pessoa = pessoaDAO.buscar(2L);

            Documento resultado = (Documento) documentoDAO.listarSequencia();

            if (resultado == null) {
                documento.setSequencia(1);
                documento.setDataCadastro(new Date());
                documento.setDescricao("689.507.801-00");
//                documento.setPessoa(pessoa);

                documentoDAO.merge(documento);
                return;
            }

            documento.setSequencia(resultado.getSequencia() + 1);
            documento.setDataCadastro(new Date());
            documento.setDescricao("689.507.801-00");
           // documento.setPessoa(pessoa);

            documentoDAO.merge(documento);

            System.out.println("Registro salvo com sucesso");

        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);

        }
    }
    
    
    @Test
    @Ignore
    public void listar() {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        List<Documento> resultado = documentoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Documento documento : resultado) {
            System.out.println(documento.getCodigo() + " - " + documento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento documento = documentoDAO.buscar(1L);

        if (documento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(documento.getCodigo() + " - " + documento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento documento = documentoDAO.buscar(codigo);

        if (documento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            documentoDAO.excluir(documento);
            System.out.println("Registro removido:");
            System.out.println(documento.getCodigo() + " - " + documento.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento documento = documentoDAO.buscar(codigo);

        if (documento == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(documento.getCodigo() + " - " + documento.getDescricao());

            documento.setDescricao("565.387.609-70");
            documento.setDataCadastro(new Date());
            documentoDAO.merge(documento);

            System.out.println("Registro editado - Depois:");
            System.out.println(documento.getCodigo() + " - " + documento.getDescricao());
        }
    }
}
