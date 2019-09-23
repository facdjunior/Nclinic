package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Endereco;
import br.com.nortesys.clinicplus.service.ServicoEndereco;
import com.google.gson.Gson;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
public class EnderecoBean implements Serializable{

    private List<Endereco> listagem = new ArrayList<Endereco>();
    private Endereco endereco;
    private String cep;

    private ServicoEndereco servico = new ServicoEndereco();

    public List<Endereco> getListagem() {
        return listagem;
    }

    public void setListagem(List<Endereco> listagem) {
        this.listagem = listagem;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void novo() {
        endereco = new Endereco();
    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/endereco");

            Gson gson = new Gson();
            String json = gson.toJson(endereco);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            Endereco[] vetor = gson.fromJson(json, Endereco[].class);
            listagem = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/endereco/");

            caminho.path("{codigo}").resolveTemplate("codigo", endereco.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Endereco[] vetor = gson.fromJson(json, Endereco[].class);

            listagem = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");
    }

    public Endereco carregarEndereco() {
        endereco = new Endereco();

        com.sun.jersey.api.client.Client c = com.sun.jersey.api.client.Client.create();
       WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
        System.out.println("CHAMOU O URI....");
        this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
        String JSON = wr.get(String.class);
        System.out.println(JSON);
        return this.getEndereco();

    }
}
