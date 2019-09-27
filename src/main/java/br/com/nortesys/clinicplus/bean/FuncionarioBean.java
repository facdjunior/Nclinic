package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.EstadoCivilDAO;
import br.com.nortesys.clinicplus.dao.FuncionarioDAO;
import br.com.nortesys.clinicplus.dao.TipoFuncionarioDAO;
import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import br.com.nortesys.clinicplus.domain.Funcionario;
import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import br.com.nortesys.clinicplus.service.ServicoEndereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.omnifaces.util.Messages;

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
        estadoCivils = estadoCivilDAO.listar("Descricao");

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        tipoFuncionarios = tipoFuncionarioDAO.listar();
    }

    public void salvar() {

    }

    public void excluir() {

    }

    public void editar() {

    }

    public Endereco carregarEndereco() {
        endereco = new Endereco();
        ServicoEndereco servico = new ServicoEndereco();

        com.sun.jersey.api.client.Client c = com.sun.jersey.api.client.Client.create();
        WebResource wr = c.resource("http://viacep.com.br/ws/" + this.funcionario.getPessoa().getEndereco().getCep() + "/json/");
        System.out.println("CHAMOU O URI....");

        this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
        String JSON = wr.get(String.class);

        System.out.println(JSON);
        
        this.funcionario.getPessoa().getEndereco().setCep(endereco.getCep());
        this.funcionario.getPessoa().getEndereco().setComplemento(endereco.getComplemento());
        this.funcionario.getPessoa().getEndereco().setGia(endereco.getGia());
        this.funcionario.getPessoa().getEndereco().setIbge(endereco.getIbge());
        this.funcionario.getPessoa().getEndereco().setLocalidade(endereco.getLocalidade());
        this.funcionario.getPessoa().getEndereco().setLogradouro(endereco.getLogradouro());
        this.funcionario.getPessoa().getEndereco().setBairro(endereco.getBairro());
        this.funcionario.getPessoa().getEndereco().setNumero(endereco.getNumero());
        this.funcionario.getPessoa().getEndereco().setUf(endereco.getUf());
        this.funcionario.getPessoa().getEndereco().setUnidade(endereco.getUnidade());

        return this.endereco;

    }

}
