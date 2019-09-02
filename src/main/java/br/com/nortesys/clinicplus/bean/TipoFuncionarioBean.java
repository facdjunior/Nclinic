package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.TipoFuncionario;
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
public class TipoFuncionarioBean {
    
    private TipoFuncionario tipoFuncionario;
    private List<TipoFuncionario> tipoFuncionarios;

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public TipoFuncionario getFabricante() {
        return tipoFuncionario;
    }

    public void setFabricante(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public List<TipoFuncionario> getTipoFuncionarios() {
        return tipoFuncionarios;
    }

    public void setTipoFuncionarios(List<TipoFuncionario> tipoFuncionarios) {
        this.tipoFuncionarios = tipoFuncionarios;
    }

   

    @PostConstruct
    public void listar() {
        try {
            
            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipofuncionario");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            TipoFuncionario[] vetor = gson.fromJson(json, TipoFuncionario[].class);

            tipoFuncionarios = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        tipoFuncionario = new TipoFuncionario();
    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipofuncionario");

            Gson gson = new Gson();
            String json = gson.toJson(tipoFuncionario);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            TipoFuncionario[] vetor = gson.fromJson(json, TipoFuncionario[].class);
            tipoFuncionarios = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            tipoFuncionario = (TipoFuncionario) evento.getComponent().getAttributes().get("tpFuncionarioSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = 
                    cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipofuncionario/");
            
            caminho.path("{codigo}").resolveTemplate("codigo", tipoFuncionario.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);
            
            Gson gson = new Gson();
            TipoFuncionario[] vetor = gson.fromJson(json, TipoFuncionario[].class);

            tipoFuncionarios = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        tipoFuncionario = (TipoFuncionario) evento.getComponent().getAttributes().get("tpFuncionarioSelecionado");
    }
}
