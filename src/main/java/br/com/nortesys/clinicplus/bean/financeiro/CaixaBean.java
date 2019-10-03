package br.com.nortesys.clinicplus.bean.financeiro;

import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import br.com.nortesys.clinicplus.service.CaixaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CaixaBean implements Serializable {

    private Caixa caixa;
    private List<Caixa> caixas;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }

    @PostConstruct
    public void listar() {
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/caixa");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Caixa[] vetor = gson.fromJson(json, Caixa[].class);

            caixas = Arrays.asList(vetor);

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }

    }

    public void novo() {

        caixa = new Caixa();

    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/caixa");

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String json = gson.toJson(caixa);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            Caixa[] vetor = gson.fromJson(json, Caixa[].class);
            caixas = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }

    }

    public void editar(ActionEvent evento) {

        caixa = (Caixa) evento.getComponent().getAttributes().get("caixaSelecionado");

    }

    public void excluir(ActionEvent evento) {

        try {
            caixa = (Caixa) evento.getComponent().getAttributes().get("caixaSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://localhost:8080/ClinicPlus/clinic/caixa/");

            caminho.path("{codigo}").resolveTemplate("codigo", caixa.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Caixa[] vetor = gson.fromJson(json, Caixa[].class);

            caixas = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");

        } catch (RuntimeException erro) {

            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }
}
