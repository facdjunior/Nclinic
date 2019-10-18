package br.com.nortesys.clinicplus.dao;

import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.Empresa;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.InformacaoAdicional;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.domain.PessoaJuridica;
import br.com.nortesys.clinicplus.domain.TipoDocumento;
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

        EmpresaDAO entidadeDAO = new EmpresaDAO();
        Empresa resultadoEntidade = (Empresa) entidadeDAO.listarSequencia();
        Empresa entidade = entidadeDAO.buscar(1L);

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

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(1L);

        if (resultadoEntidade == null) {
            entidade.setDataCadastro(new Date());
            entidade.setPessoa(pessoa);
            entidade.setSequencia(1L);
        } else {
            entidade.setDataCadastro(new Date());
            entidade.setPessoa(pessoa);
            entidade.setSequencia(resultadoEntidade.getSequencia() + 1);
        }

        if (resultadoPessoa == null) {

            pessoa.setNome("NORTESYS DESENVOLVIMENTO DE SISTEMAS");
            pessoa.setDataCadastro(new Date());
            pessoa.setSequencia(1L);
            System.out.println("teste:" + pessoa.getCodigo());
            System.out.println("Registro Novo sem sequencia!");

        } else {

            pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
            pessoa.setNome("Bento Felipe Yago Figueiredo");
            pessoa.setDataCadastro(new Date());

        }
        if (resultadoPJuridica == null) {

            pessoaJuridica.setDataCadastro(new Date());
            pessoaJuridica.setEntidade(entidade);
            pessoaJuridica.setRazao("NORTESYS DESENVOLVIMENTO DE SISTEMAS LTDA-ME");
            pessoaJuridica.setSequencia(1);

        } else {

            pessoaJuridica.setDataCadastro(new Date());
            pessoaJuridica.setEntidade(entidade);
            pessoaJuridica.setRazao("NORTESYS DESENVOLVIMENTO DE SISTEMAS LTDA-ME");
            pessoaJuridica.setSequencia(resultadoPJuridica.getSequencia() + 1);
        }

        InformacaoAdicional inforAdicional = new InformacaoAdicional();
        InformacaoAdicionalDAO inforAdicionaisDAO = new InformacaoAdicionalDAO();
        InformacaoAdicional resultadoInfor = (InformacaoAdicional) inforAdicionaisDAO.listarSequencia();

        if (resultadoInfor == null) {

            inforAdicional.setEntidade(entidade);
            inforAdicional.setDataCadastro(new Date());
            inforAdicional.setDescricao("");
            inforAdicional.setPessoa(pessoa);
            inforAdicional.setSequencia(1L);

        } else {

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
            contato.setEntidade(entidade);
            contato.setPessoa(pessoa);
            contato.setSequencia(1L);

        } else {

            contato.setDataCadastro(new Date());
            contato.setEntidade(entidade);
            contato.setPessoa(pessoa);
            contato.setSequencia(resultadoContato.getSequencia() + 1);
        }
        
        contatoDAO.salvar(contato);

        if (resultaEndereco == null) {

            endereco.setAtivo(true);
            endereco.setLogradouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(1L);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");

        } else {

            endereco.setAtivo(true);
            endereco.setLogradouro("Rua Muiratinga");
            endereco.setCep("69093-129");
            endereco.setSequencia(resultaEndereco.getSequencia() + 1);
            endereco.setComplemento("João teste Complemento");
            endereco.setDataCadastro(new Date());
            endereco.setNumero("310");

        }

        if (resultadoDocumento == null) {

            documento.setDataCadastro(new Date());
            documento.setTipoDocumento(tipoDocumento);
            documento.setDescricao("405.076.621-30");
            documento.setSequencia(1);
            documento.setEntidade(entidade);
        } else {
            documento.setDataCadastro(new Date());
            documento.setDescricao("405.076.621-30");
            documento.setTipoDocumento(tipoDocumento);
            documento.setSequencia(resultadoDocumento.getSequencia() + 1);
            documento.setEntidade(entidade);
        }

        pessoaDAO.merge(pessoa);
        //entidadeDAO.merge(entidade);
    }
}
