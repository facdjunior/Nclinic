package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Pessoa;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class ContatoDAOTest {

    @Test
    @Ignore
    public void salvar() {
        try {

            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa pessoa = pessoaDAO.buscar(1L);

            ContatoDAO contatoDAO = new ContatoDAO();
            Contato contato = new Contato();

            Contato resultado = (Contato) contatoDAO.listarSequencia();

            if (resultado == null) {
                contato.setSequencia(1l);
                contato.setCelular("(91)98658-8083");
                contato.setCelular1("(91)93963-6057");
                contato.setDataCadastro(new Date());
                contato.setFone("(91)3963-6057");
              //  contato.setPessoa(pessoa);

                contatoDAO.merge(contato);
                return;
            }
            contato.setSequencia(resultado.getSequencia() + 1);
            contato.setCelular("(91)98658-8083");
            contato.setCelular1("(91)93963-6057");
            contato.setDataCadastro(new Date());
            contato.setFone("(91)3963-6057");
           // contato.setPessoa(pessoa);

            contatoDAO.merge(contato);

            System.out.println("Registro salvo com sucesso");
        } catch (RuntimeException e) {

            System.out.println("Erro ao salvar Registro" + e);
        }
    }
    
    @Test
    @Ignore
    public void listar() {
        ContatoDAO contatoDAO = new ContatoDAO();
        List<Contato> resultado = contatoDAO.listar();

        System.out.println("Total de Registros Encontrados: " + resultado.size());

        for (Contato contato : resultado) {
            System.out.println(contato.getCodigo() + " - " + contato.getFone());
        }
    }
    
    @Test
    @Ignore
    public void buscar() {
        //Long codigo = 3L;

        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = contatoDAO.buscar(1L);

        if (contato == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(contato.getCodigo() + " - " + contato.getCelular());
        }
    }
    
    @Test
    @Ignore
    public void excluir() {
        Long codigo = 2L;
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = contatoDAO.buscar(codigo);

        if (contato == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            contatoDAO.excluir(contato);
            System.out.println("Registro removido:");
            System.out.println(contato.getCodigo() + " - " + contato.getCelular());
        }
    }
    
    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = contatoDAO.buscar(codigo);

        if (contato == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro editado - Antes:");
            System.out.println(contato.getCodigo() + " - " + contato.getCelular());

            contato.setCelular("(83)99340-2294");
            contato.setDataCadastro(new Date());
            contatoDAO.merge(contato);

            System.out.println("Registro editado - Depois:");
            System.out.println(contato.getCodigo() + " - " + contato.getCelular());
        }
    }
    
}
