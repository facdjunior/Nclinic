package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco
 */
public class ClienteDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica resultadoPFisica = (PessoaFisica) pessoaFisicaDAO.listarSequencia();

        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa resultadoPessoa = (Pessoa) pessoaDAO.listarSequencia();

        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco resultaEndereco = (Endereco) enderecoDAO.listarSequencia();

        if (resultadoPessoa == null) {

            pessoa.setNome("Sérgio André Nicolas Fogaça");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);
            pessoa.setPessoaFisica(pessoaFisica);

            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Bento Felipe Yago Figueiredo");
            pessoa.setDataCadastro(new Date());
            pessoa.setPessoaFisica(pessoaFisica);

        }
        if (resultadoPFisica == null) {

            String data = "21/04/1950";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Manaus");
            pessoaFisica.setSequencia(1);
            pessoaFisica.setSexo('F');
        } else {

            String data = "21/04/1950";
            pessoaFisica.setDataCadastro(new Date());
            pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            pessoaFisica.setEstadoCivil(estadoCivil);
            pessoaFisica.setGrauEscolaridade("2º Grau");
            pessoaFisica.setNaturalidade("Manaus");
            pessoaFisica.setSequencia(resultadoPFisica.getSequencia() + 1);
            pessoaFisica.setSexo('F');
        }

        pessoaDAO.salvar(pessoa);

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

        if (resultadoContato == null) {

            contato.setCelular("(92)98395-0668");
            contato.setDataCadastro(new Date());
            contato.setFone("(92)3906-2716");
            contato.setPessoa(pessoa);
            contato.setSequencia(1L);

        } else {
            contato.setCelular("(92)98395-0668");
            contato.setDataCadastro(new Date());
            contato.setFone("(92)3906-2716");
            contato.setPessoa(pessoa);
            contato.setSequencia(resultadoContato.getSequencia() + 1);
        }
        contatoDAO.merge(contato);

        if (resultaEndereco == null) {

            endereco.setAtivo(true);
            endereco.setBairro("Monte das Oliveiras");
            endereco.setDescricao("Rua Muiratinga");
            endereco.setCEP("69093-129");
            endereco.setSequencia(1L);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");
            endereco.setObservacao("Manaus");
            endereco.setPessoa(pessoa);

        } else {

            endereco.setAtivo(true);
            endereco.setBairro("Monte das Oliveiras");
            endereco.setDescricao("Rua Muiratinga");
            endereco.setCEP("69093-129");
            endereco.setSequencia(resultaEndereco.getSequencia() + 1);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");
            endereco.setObservacao("Manaus");
            endereco.setPessoa(pessoa);
        }
        enderecoDAO.merge(endereco);

    }
    
    public void listar(){
        
    }

}
