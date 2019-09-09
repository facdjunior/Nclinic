package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.EstadoCivil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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
public class EstadoCivilBean{
    
    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadoCivils;

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
    
    @PostConstruct
    public void listar() {
        try {
            
            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/estadoCivil");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            EstadoCivil[] vetor = gson.fromJson(json, EstadoCivil[].class);

            estadoCivils = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        estadoCivil = new EstadoCivil();
    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/estadoCivil");

            Gson gson = new Gson();
            String json = gson.toJson(estadoCivil);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            EstadoCivil[] vetor = gson.fromJson(json, EstadoCivil[].class);
            estadoCivils = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            estadoCivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoCivilSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = 
                    cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/estadoCivil/");
            
            caminho.path("{codigo}").resolveTemplate("codigo", estadoCivil.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);
            
            Gson gson = new Gson();
            EstadoCivil[] vetor = gson.fromJson(json, EstadoCivil[].class);

            estadoCivils = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        
        estadoCivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoCivilSelecionado");
    }
    
}
