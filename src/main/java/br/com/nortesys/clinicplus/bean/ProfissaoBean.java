package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Profissao;
import com.google.gson.Gson;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Junior 2019-08-05
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProfissaoBean {
    
     private Profissao profissao;
    private List<Profissao> profissaos;

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Profissao getFabricante() {
        return profissao;
    }

    public void setFabricante(Profissao profissao) {
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
            
            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/profissao");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Profissao[] vetor = gson.fromJson(json, Profissao[].class);

            profissaos = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        profissao = new Profissao();
    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/profissao");

            Gson gson = new Gson();
            String json = gson.toJson(profissao);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            Profissao[] vetor = gson.fromJson(json, Profissao[].class);
            profissaos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            profissao = (Profissao) evento.getComponent().getAttributes().get("profissaoSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = 
                    cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/profissao/");
            
            caminho.path("{codigo}").resolveTemplate("codigo", profissao.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);
            
            Gson gson = new Gson();
            Profissao[] vetor = gson.fromJson(json, Profissao[].class);

            profissaos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        profissao = (Profissao) evento.getComponent().getAttributes().get("profissaoSelecionado");
    }
}
