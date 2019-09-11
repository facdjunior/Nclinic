package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ClienteDAO;
import br.com.nortesys.clinicplus.dao.ContatoDAO;
import br.com.nortesys.clinicplus.dao.DocumentoDAO;
import br.com.nortesys.clinicplus.dao.EnderecoDAO;
import br.com.nortesys.clinicplus.dao.EstadoCivilDAO;
import br.com.nortesys.clinicplus.dao.PessoaDAO;
import br.com.nortesys.clinicplus.dao.PessoaFisicaDAO;
import br.com.nortesys.clinicplus.dao.ProfissaoDAO;
import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Documento;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Pessoa;

import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.domain.Profissao;
import br.com.nortesys.clinicplus.domain.TipoDocumento;
import br.com.nortesys.clinicplus.service.ServicoEndereco;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.WebResource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ActionEvent;
import javax.persistence.OneToOne;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.WebTarget;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Junior 2019-08-05
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente cliente;
    private List<Cliente> clientes;

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    private PessoaFisica pessoaFisica;
    private List<PessoaFisica> pessoaFisicas;

    private Documento documento;
    private List<Documento> documentos;

    private Endereco endereco;
    private List<Endereco> enderecos;

    private Contato contato;
    private List<Contato> contatos;

    private TipoDocumento tipoDocumento;
    private List<TipoDocumento> tipoDocumentos;

    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadoCivils;

    private Profissao profissao;
    private List<Profissao> profissaos;

    private String cep;

    private ServicoEndereco servico = new ServicoEndereco();

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(List<TipoDocumento> tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<EstadoCivil> getEstadoCivils() {
        return estadoCivils;
    }

    public void setEstadoCivils(List<EstadoCivil> estadoCivils) {
        this.estadoCivils = estadoCivils;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getProfissaos() {
        return profissaos;
    }

    public void setProfissaos(List<Profissao> profissaos) {
        this.profissaos = profissaos;
    }

    @PostConstruct
    public void listar() {
        try {

            ClienteDAO clienteDAO = new ClienteDAO();
            clientes = clienteDAO.listar();
            /*     
            Client ccliente = ClientBuilder.newClient();
            WebTarget caminho = ccliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/cliente");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Cliente[] vetor = gson.fromJson(json, Cliente[].class);

            clientes = Arrays.asList(vetor);*/
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {

        cliente = new Cliente();
        pessoa = new Pessoa();
        pessoaFisica = new PessoaFisica();
        contato = new Contato();
        documento = new Documento();
        profissao = new Profissao();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        profissaoDAO.listar("Descricao");

        estadoCivil();
        listar();

    }

    public void salvar() {
        try {

            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaFisica resultadoPFisica = (PessoaFisica) pessoaFisicaDAO.listarSequencia();

            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa resultadoPessoa = (Pessoa) pessoaDAO.listarSequencia();

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco resultaEndereco = (Endereco) enderecoDAO.listarSequencia();

            DocumentoDAO documentoDAO = new DocumentoDAO();
            Documento resultadoDocumento = (Documento) documentoDAO.listarSequencia();

            if (resultadoPessoa == null) {

                pessoa.setDataCadastro(new Date());
                pessoa.setSequencia(1L);
                pessoa.setPessoaFisica(pessoaFisica);

                System.out.println("Registro Novo sem sequencia!" + pessoa.getCodigo());

            } else if (resultadoPessoa.getCodigo() > 1) {
                //   pessoa.setSequencia(resultadoPessoa.getSequencia());
                // pessoa.setDataCadastro(new Date());
                // pessoa.setPessoaFisica(pessoaFisica);
                System.out.println("Registro Novo sem sequencia!" + pessoa.getCodigo());
                pessoaDAO.merge(pessoa);
            } else {

                pessoa.setSequencia(resultadoPessoa.getSequencia() + 1);
                pessoa.setDataCadastro(new Date());
                pessoa.setPessoaFisica(pessoaFisica);

            }

            if (resultadoPFisica == null) {

                pessoaFisica.setDataCadastro(new Date());
                pessoaFisica.setSequencia(1);

            } else if (resultadoPFisica.getCodigo() > 1) {
                pessoaFisicaDAO.merge(pessoaFisica);
            } else {
                pessoaFisica.setDataCadastro(new Date());
                pessoaFisica.setSequencia(resultadoPFisica.getSequencia() + 1);
            }

            if (resultaEndereco == null) {

                endereco.setSequencia(1L);
                endereco.setDataCadastro(new Date());
                endereco.setPessoa(pessoa);

            } else if (resultaEndereco.getCodigo() > 1) {

            } else {

                endereco.setSequencia(resultaEndereco.getSequencia() + 1);
                endereco.setDataCadastro(new Date());
                endereco.setPessoa(pessoa);
            }

            enderecoDAO.merge(endereco);

            if (resultadoDocumento == null) {
                documento.setDataCadastro(new Date());
                documento.setSequencia(1);
                documento.setPessoa(pessoa);
            } else {
                documento.setDataCadastro(new Date());
                documento.setSequencia(resultadoDocumento.getSequencia() + 1);
                documento.setPessoa(pessoa);
            }

            documentoDAO.merge(documento);

            ContatoDAO contatoDAO = new ContatoDAO();
            Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

            if (resultadoContato == null) {

                contato.setDataCadastro(new Date());
                contato.setSequencia(1L);
                contato.setPessoa(pessoa);

            } else {

                contato.setDataCadastro(new Date());
                contato.setSequencia(resultadoContato.getSequencia() + 1);
                contato.setPessoa(pessoa);
            }

            contatoDAO.merge(contato);

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

            novo();
            listar();

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Erro ao tentar gravar Registro");
            erro.printStackTrace();
        }

    }

    public void excluir(ActionEvent evento) {

    }

    public void editar(ActionEvent evento) {
        try {

            cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
            estadoCivils = estadoCivilDAO.listar();

        } catch (Exception erro) {

            Messages.addGlobalError("Ocorreu um erro ao gerar lista de estado civil");
            erro.printStackTrace();
        }

    }

    public void estadoCivil() {
        try {
            Client ccliente = ClientBuilder.newClient();
            WebTarget caminho = ccliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/estadoCivil");
            String json = caminho.request().get(String.class
            );

            Gson gson = new Gson();
            EstadoCivil[] vetor = gson.fromJson(json, EstadoCivil[].class);

            estadoCivils = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public Endereco carregarEndereco() {

        endereco = new Endereco();
        String resultado = this.getCep();

        com.sun.jersey.api.client.Client c = com.sun.jersey.api.client.Client.create();
        WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
        System.out.println("CHAMOU O URI....");

        this.endereco = servico.buscarEnderecoPor(wr.get(String.class
        ));
        String JSON = wr.get(String.class);

        System.out.println(JSON);

        return this.getEndereco();

    }

}
