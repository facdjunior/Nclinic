package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.Entidade;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.InformacaoAdicional;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.domain.PessoaJuridica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Junior
 */
public class EntidadeDAOTest {

    @Test
    //@Ignore
    public void salvar() throws ParseException {

        Entidade entidade = new Entidade();
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade resultadoEntidade = (Entidade) entidadeDAO.listarSequencia();

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(1L);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica resultadoPJuridica = (PessoaJuridica) pessoaJuridicaDAO.listarSequencia();

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        Pessoa resultadoPessoa = (Pessoa) pessoaDAO.listarSequencia();

        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco resultaEndereco = (Endereco) enderecoDAO.listarSequencia();

        Documento documento = new Documento();
        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento resultadoDocumento = (Documento) documentoDAO.listarSequencia();

        if (resultadoPessoa == null) {
            pessoa.setCodigo(entidade.getCodigo()+pessoa.getCodigo());
            pessoa.setNome("NORTESYS DESENVOLVIMENTO DE SISTEMAS");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);
            System.out.println("teste:"+pessoa.getCodigo());
            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Bento Felipe Yago Figueiredo");
            pessoa.setDataCadastro(new Date());

        }
        if (resultadoPJuridica == null) {
            pessoaJuridica.setCodigo(entidade.getCodigo() +pessoaJuridica.getCodigo());
            pessoaJuridica.setDataCadastro(new Date());
            pessoaJuridica.setEntidade(entidade);
            pessoaJuridica.setRazao("NORTESYS DESENVOLVIMENTO DE SISTEMAS LTDA-ME");
            pessoaJuridica.setSequencia(1);
            
        } else {
            
            pessoaJuridica.setCodigo(entidade.getCodigo()+pessoaJuridica.getCodigo());
            pessoaJuridica.setDataCadastro(new Date());
            pessoaJuridica.setEntidade(entidade);
            pessoaJuridica.setRazao("NORTESYS DESENVOLVIMENTO DE SISTEMAS LTDA-ME");
            pessoaJuridica.setSequencia(resultadoPJuridica.getSequencia() + 1);
        }
        
        InformacaoAdicional inforAdicional = new InformacaoAdicional();
        InformacaoAdicionalDAO inforAdicionaisDAO = new InformacaoAdicionalDAO();
        InformacaoAdicional resultadoInfor = (InformacaoAdicional) inforAdicionaisDAO.listarSequencia();
        
        if(resultadoInfor == null){
            inforAdicional.setCodigo(entidade.getCodigo() +inforAdicional.getCodigo());
            inforAdicional.setEntidade(entidade);
            inforAdicional.setDataCadastro(new Date());
            inforAdicional.setDescricao("");
            inforAdicional.setPessoa(pessoa);
            inforAdicional.setSequencia(1L);
        }else{
            inforAdicional.setCodigo(entidade.getCodigo() +inforAdicional.getCodigo());
            inforAdicional.setDataCadastro(new Date());
            inforAdicional.setDescricao("");
            inforAdicional.setPessoa(pessoa);
            inforAdicional.setSequencia(resultadoInfor.getCodigo() + 1L);
        }

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

        if (resultadoContato == null) {

            contato.setDataCadastro(new Date());
            contato.setSequencia(1L);

        } else {

            contato.setDataCadastro(new Date());


            contato.setSequencia(resultadoContato.getSequencia() + 1);
        }

        pessoaDAO.merge(pessoa);

        contatoDAO.merge(contato);

        if (resultaEndereco
                == null) {

            endereco.setAtivo(true);
            endereco.setLogradouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(1L);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");

            endereco.setPessoa(pessoa);

        } else {

            endereco.setAtivo(true);
            endereco.setLogradouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(resultaEndereco.getSequencia() + 1);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");

            endereco.setPessoa(pessoa);
        }

        enderecoDAO.merge(endereco);

        if (resultadoDocumento
                == null) {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            // documento.setPessoa(pessoa);
            documento.setSequencia(1);
        } else {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            // documento.setPessoa(pessoa);
            documento.setSequencia(resultadoDocumento.getSequencia() + 1);
        }
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente resultadoCliente = (Cliente) clienteDAO.listarSequencia();

        if (resultadoCliente == null) {
            cliente.setDataCadastro(new Date());
            cliente.setPessoa(pessoa);
            cliente.setSequencia(1);
        } else {
            cliente.setDataCadastro(new Date());
            cliente.setPessoa(pessoa);
            cliente.setSequencia(resultadoCliente.getSequencia() + 1);
        }

        clienteDAO.merge(cliente);
    }
}
