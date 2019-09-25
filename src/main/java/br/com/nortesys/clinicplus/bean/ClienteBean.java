package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ClienteDAO;
import br.com.nortesys.clinicplus.dao.ContatoDAO;
import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.dao.DocumentoDAO;
import br.com.nortesys.clinicplus.dao.EnderecoDAO;
import br.com.nortesys.clinicplus.dao.EstadoCivilDAO;
import br.com.nortesys.clinicplus.dao.PessoaDAO;
import br.com.nortesys.clinicplus.dao.PessoaFisicaDAO;
import br.com.nortesys.clinicplus.dao.ProfissaoDAO;
import br.com.nortesys.clinicplus.dao.TipoConvenioDAO;
import br.com.nortesys.clinicplus.domain.CartaoConvenio;
import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.Documento;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Pessoa;

import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.domain.Profissao;
import br.com.nortesys.clinicplus.domain.TipoConvenio;
import br.com.nortesys.clinicplus.service.ClienteService;
import br.com.nortesys.clinicplus.service.ServicoEndereco;

import com.google.gson.Gson;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ActionEvent;
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
public class ClienteBean implements Serializable {

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

    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadoCivils;

    private Profissao profissao;
    private List<Profissao> profissaos;

    private CartaoConvenio cartaoConvenio;
    private List<CartaoConvenio> cartaoConvenios;

    private String cep;

    private ServicoEndereco servico = new ServicoEndereco();

    private Convenio convenio;
    private List<Convenio> convenios;

    private TipoConvenio tipoConvenio;
    private List<TipoConvenio> tipoConvenios;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public TipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public List<TipoConvenio> getTipoConvenios() {
        return tipoConvenios;
    }

    public void setTipoConvenios(List<TipoConvenio> tipoConvenios) {
        this.tipoConvenios = tipoConvenios;
    }

    public CartaoConvenio getCartaoConvenio() {
        return cartaoConvenio;
    }

    public void setCartaoConvenio(CartaoConvenio cartaoConvenio) {
        this.cartaoConvenio = cartaoConvenio;
    }

    public List<CartaoConvenio> getCartaoConvenios() {
        return cartaoConvenios;
    }

    public void setCartaoConvenios(List<CartaoConvenio> cartaoConvenios) {
        this.cartaoConvenios = cartaoConvenios;
    }

    public ServicoEndereco getServico() {
        return servico;
    }

    public void setServico(ServicoEndereco servico) {
        this.servico = servico;
    }

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
        profissao = new Profissao();
        convenio = new Convenio();
        estadoCivil = new EstadoCivil();
        tipoConvenio = new TipoConvenio();

        
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        profissaos = profissaoDAO.listar("Descricao");

        ConvenioDAO convenioDAO = new ConvenioDAO();
        convenios = convenioDAO.listar("Descricao");

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        estadoCivils = estadoCivilDAO.listar("Descricao");
        
        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        tipoConvenios = tipoConvenioDAO.listar("Descricao");

        listar();

    }

    public void dadosCliente() {

        if (cliente.getCodigo() == null) {

            try {
                PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                PessoaFisica resultadoPessoaFisica = (PessoaFisica) pessoaFisicaDAO.listarSequencia();

                if (resultadoPessoaFisica == null) {
                    this.cliente.getPessoa().getPessoaFisica().setSequencia(1);
                    this.cliente.getPessoa().getPessoaFisica().setDataCadastro(new Date());
                    this.cliente.getPessoa().getPessoaFisica().setIdade(pessoaFisicaDAO.idade());
                } else {
                    this.cliente.getPessoa().getPessoaFisica().setSequencia(resultadoPessoaFisica.getSequencia() + 1);
                    this.cliente.getPessoa().getPessoaFisica().setDataCadastro(new Date());
                }

                PessoaDAO pessoaDAO = new PessoaDAO();
                Pessoa resultadoPesssoa = (Pessoa) pessoaDAO.listarSequencia();

                if (resultadoPesssoa == null) {
                    this.cliente.getPessoa().setSequencia(1L);
                    this.cliente.getPessoa().setDataCadastro(new Date());
                } else {
                    this.cliente.getPessoa().setSequencia(resultadoPesssoa.getSequencia() + 1L);
                    this.cliente.getPessoa().setDataCadastro(new Date());
                }

                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco resultadoEndereco = (Endereco) enderecoDAO.listarSequencia();

                if (resultadoEndereco == null) {
                    this.cliente.getPessoa().getEndereco().setSequencia(1L);
                    this.cliente.getPessoa().getEndereco().setDataCadastro(new Date());

                } else {
                    this.cliente.getPessoa().getEndereco().setSequencia(resultadoEndereco.getSequencia() + 1L);
                    this.cliente.getPessoa().getEndereco().setDataCadastro(new Date());

                }

                ContatoDAO contatoDAO = new ContatoDAO();
                Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

                if (resultadoContato == null) {
                    this.cliente.getPessoa().getContato().setSequencia(1L);
                    this.cliente.getPessoa().getContato().setDataCadastro(new Date());

                } else {
                    this.cliente.getPessoa().getContato().setSequencia(resultadoContato.getSequencia() + 1);
                    this.cliente.getPessoa().getContato().setDataCadastro(new Date());

                }

                DocumentoDAO documentoDAO = new DocumentoDAO();
                Documento resultadoDocumento = (Documento) documentoDAO.listarSequencia();

                if (resultadoDocumento == null) {

                    this.cliente.getPessoa().getDocumento().setSequencia(1);
                    this.cliente.getPessoa().getDocumento().setDataCadastro(new Date());

                } else {
                    this.cliente.getPessoa().getDocumento().setSequencia(resultadoDocumento.getSequencia() + 1);
                    this.cliente.getPessoa().getDocumento().setDataCadastro(new Date());

                }

            } catch (RuntimeException erro) {

                Messages.addGlobalError("Erro ao tentar gravar Registro");
                erro.printStackTrace();
            }
        }
    }

    public void salvar() {
        try {
            dadosCliente();
            // pessoa.setSequencia(10L);
            if (cliente.getCodigo() == null) {

                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente resultadoCliente = (Cliente) clienteDAO.listarSequencia();

                if (resultadoCliente == null) {
                    cliente.setDataCadastro(new Date());
                    cliente.setSequencia(1);

                } else {

                    cliente.setDataCadastro(new Date());
                    cliente.setSequencia(resultadoCliente.getSequencia() + 1);

                }
                // dadosCliente();
                clienteDAO.merge(cliente);
            } else {

                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.merge(cliente);
            }
            Messages.addGlobalInfo("Registro gravado com Sucesso!");
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

            ClienteDAO clienteDAO = new ClienteDAO();
            clientes = clienteDAO.listar();
            
            ConvenioDAO convenioDAO = new ConvenioDAO();
            convenios = convenioDAO.listar("Descricao");
            
            TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
            tipoConvenios = tipoConvenioDAO.listar("Descricao");
            
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

        com.sun.jersey.api.client.Client c = com.sun.jersey.api.client.Client.create();
        WebResource wr = c.resource("http://viacep.com.br/ws/" + this.cliente.getPessoa().getEndereco().getCep() + "/json/");
        System.out.println("CHAMOU O URI....");

        this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
        String JSON = wr.get(String.class);

        System.out.println(JSON);
        this.cliente.getPessoa().getEndereco().setCep(endereco.getCep());
        this.cliente.getPessoa().getEndereco().setComplemento(endereco.getComplemento());
        this.cliente.getPessoa().getEndereco().setGia(endereco.getGia());
        this.cliente.getPessoa().getEndereco().setIbge(endereco.getIbge());
        this.cliente.getPessoa().getEndereco().setLocalidade(endereco.getLocalidade());
        this.cliente.getPessoa().getEndereco().setLogradouro(endereco.getLogradouro());
        this.cliente.getPessoa().getEndereco().setNumero(endereco.getNumero());
        this.cliente.getPessoa().getEndereco().setUf(endereco.getUf());
        this.cliente.getPessoa().getEndereco().setUnidade(endereco.getUnidade());

        return this.endereco;

    }

    public String IdadeCalcular() {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.idade();

        return IdadeCalcular();
    }

}
