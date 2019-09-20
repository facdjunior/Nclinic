package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.PessoaDAO;
import br.com.nortesys.clinicplus.domain.Pessoa;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.service.PessoaFisicaService;
import br.com.nortesys.clinicplus.service.PessoaService;
import com.google.gson.Gson;
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
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

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

    @PostConstruct
    public void listar() {
        try {
            
            
            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/pessoa");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Pessoa[] vetor = gson.fromJson(json, Pessoa[].class);

            pessoas = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        pessoa = new Pessoa();
    }

    public void salvar() {

        try {
            
            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa resultado = (Pessoa) pessoaDAO.listarSequencia();
              
            
            
            
            PessoaService pessoaService = new PessoaService();
            
            novo();
            listar();

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Erro ao tentar gravar Registro");
            erro.printStackTrace();
        }
        /*
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/pessoaFisica");

            Gson gson = new Gson();
            String json = gson.toJson(pessoaFisica);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            PessoaFisica[] vetor = gson.fromJson(json, PessoaFisica[].class);
            pessoaFisicas = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }*/
    }

    public void excluir(ActionEvent evento) {
        try {
            pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/pessoa/");

            caminho.path("{codigo}").resolveTemplate("codigo", pessoa.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Pessoa[] vetor = gson.fromJson(json, Pessoa[].class);

            pessoas = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
    }
    
    
}
