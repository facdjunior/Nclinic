package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ContatoDAO;
import br.com.nortesys.clinicplus.dao.DocumentoDAO;
import br.com.nortesys.clinicplus.dao.EnderecoDAO;
import br.com.nortesys.clinicplus.dao.EstadoCivilDAO;
import br.com.nortesys.clinicplus.dao.FuncionarioDAO;

import br.com.nortesys.clinicplus.dao.PessoaDAO;
import br.com.nortesys.clinicplus.dao.TipoFuncionarioDAO;
import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.domain.Endereco;

import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Funcionario;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import br.com.nortesys.clinicplus.service.ServicoEndereco;

import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadoCivils;

    private TipoFuncionario tipoFuncionario;
    private List<TipoFuncionario> tipoFuncionarios;

    private Endereco endereco;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<EstadoCivil> getEstadoCivils() {
        return estadoCivils;
    }

    public void setEstadoCivils(List<EstadoCivil> estadoCivils) {
        this.estadoCivils = estadoCivils;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public List<TipoFuncionario> getTipoFuncionarios() {
        return tipoFuncionarios;
    }

    public void setTipoFuncionarios(List<TipoFuncionario> tipoFuncionarios) {
        this.tipoFuncionarios = tipoFuncionarios;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @PostConstruct
    public void listar() {
        try {

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarios = funcionarioDAO.listar();
            /* implementar no sistema o serviço Funcionarios;
            Client ccliente = ClientBuilder.newClient();
            WebTarget caminho = ccliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/funcionario");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Funcionario[] vetor = gson.fromJson(json, Funcionario[].class);

            funcionarios = Arrays.asList(vetor);
             */
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {

        funcionario = new Funcionario();

        estadoCivil = new EstadoCivil();
        tipoFuncionario = new TipoFuncionario();

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        estadoCivils = estadoCivilDAO.listar();

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        tipoFuncionarios = tipoFuncionarioDAO.listar();
    }

    public void dadosCliente() {

        if (funcionario.getCodigo() == null) {

            try {
                
                PessoaDAO pessoaDAO = new PessoaDAO();
                Pessoa resultadoPesssoa = (Pessoa) pessoaDAO.listarSequencia();

                if (resultadoPesssoa == null) {
                    this.funcionario.getPessoa().setSequencia(1L);
                    this.funcionario.getPessoa().setDataCadastro(new Date());
                } else {
                    this.funcionario.getPessoa().setSequencia(resultadoPesssoa.getSequencia() + 1L);
                    this.funcionario.getPessoa().setDataCadastro(new Date());
                }

                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco resultadoEndereco = (Endereco) enderecoDAO.listarSequencia();

                if (resultadoEndereco == null) {
                    this.funcionario.getPessoa().getEndereco().setSequencia(1L);
                    this.funcionario.getPessoa().getEndereco().setDataCadastro(new Date());

                } else {
                    this.funcionario.getPessoa().getEndereco().setSequencia(resultadoEndereco.getSequencia() + 1L);
                    this.funcionario.getPessoa().getEndereco().setDataCadastro(new Date());

                }

                ContatoDAO contatoDAO = new ContatoDAO();
                Contato resultadoContato = (Contato) contatoDAO.listarSequencia();

                if (resultadoContato == null) {
                    this.funcionario.getPessoa().getContato().setSequencia(1L);
                    this.funcionario.getPessoa().getContato().setDataCadastro(new Date());

                } else {
                    this.funcionario.getPessoa().getContato().setSequencia(resultadoContato.getSequencia() + 1);
                    this.funcionario.getPessoa().getContato().setDataCadastro(new Date());

                }

                DocumentoDAO documentoDAO = new DocumentoDAO();
                Documento resultadoDocumento = (Documento) documentoDAO.listarSequencia();

                if (resultadoDocumento == null) {

                    this.funcionario.getPessoa().getDocumento().setSequencia(1);
                    this.funcionario.getPessoa().getDocumento().setDataCadastro(new Date());

                } else {
                    this.funcionario.getPessoa().getDocumento().setSequencia(resultadoDocumento.getSequencia() + 1);
                    this.funcionario.getPessoa().getDocumento().setDataCadastro(new Date());

                }
            } catch (RuntimeException erro) {

                Messages.addGlobalError("Erro ao tentar gravar Registro");
                erro.printStackTrace();
            }
        }
    }

    public void salvar() {
        try {
            
            if(funcionario.getCaminho()==null){
                Messages.addGlobalError("Favor inserir foto");
                return;
            }

            dadosCliente();

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario resultadoSequencia = funcionarioDAO.listarSequencia();

            if (resultadoSequencia == null) {
                funcionario.setSequencia(1);
                funcionario.setDataCadastro(new Date());
            } else {
                funcionario.setSequencia(resultadoSequencia.getSequencia() + 1);
                funcionario.setDataCadastro(new Date());
            }

            Funcionario funcionarioRetorno = funcionarioDAO.merge(funcionario);
            Path origem = Paths.get(funcionario.getCaminho());
            Path destino = Paths.get("D:/Curso/imagemProjeto/"+funcionarioRetorno.getCodigo()+ ".png");
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

            Messages.addGlobalInfo("Registro salvo com Sucesso");

            novo();
            listar();

        } catch (RuntimeException | IOException erro) {

            Messages.addGlobalError("Erro ao gravar Cadastro!");
            erro.printStackTrace();
        }

    }

    public void excluir(ActionEvent evento) {

        try {
            funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.excluir(funcionario);
            
            Path arquivo = Paths.get("D:/Curso/imagemProjeto/" +funcionario.getCodigo()+ ".png");
            Files.deleteIfExists(arquivo);

            funcionarios = funcionarioDAO.listar();

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException | IOException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        try {

            funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
            funcionario.setCaminho("D:/Curso/imagemProjeto/" +funcionario.getCodigo()+ ".png");

            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
            estadoCivils = estadoCivilDAO.listar();

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarios = funcionarioDAO.listar();

            TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            tipoFuncionarios = tipoFuncionarioDAO.listar("Descricao");

        } catch (Exception erro) {

            Messages.addGlobalError("Ocorreu um erro ao gerar lista de estado civil");
            erro.printStackTrace();
        }

    }

    public Endereco carregarEndereco() {
        endereco = new Endereco();
        ServicoEndereco servico = new ServicoEndereco();

        com.sun.jersey.api.client.Client c = com.sun.jersey.api.client.Client.create();
        WebResource wr = c.resource("http://viacep.com.br/ws/" + this.funcionario.getPessoa().getEndereco().getCep() + "/json/");
        System.out.println("CHAMOU O URI....");

        this.endereco = servico.buscarEnderecoPor(wr.get(String.class
        ));
        String JSON = wr.get(String.class);

        System.out.println(JSON);

        this.funcionario.getPessoa()
                .getEndereco().setCep(endereco.getCep());

        this.funcionario.getPessoa()
                .getEndereco().setComplemento(endereco.getComplemento());

       
        this.funcionario.getPessoa()
                .getEndereco().setLogradouro(endereco.getLogradouro());

        this.funcionario.getPessoa()
                .getEndereco().setNumero(endereco.getNumero());

        return this.endereco;
    }
    
    public void upload(FileUploadEvent evento) {
        try {
            UploadedFile arquivoUpload = evento.getFile();
            Path arquivoTemp = Files.createTempFile(null, null);

            Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
            funcionario.setCaminho(arquivoTemp.toString());
            
            Messages.addGlobalInfo("Funcionario"+funcionario.getCaminho());
            System.out.println(funcionario.getCaminho());
            
            
        } catch (IOException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar realizar upload do arquivo");
            erro.printStackTrace();
        }
    }
}
