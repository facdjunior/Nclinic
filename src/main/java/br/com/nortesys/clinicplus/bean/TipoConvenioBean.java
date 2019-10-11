package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Convenio;
import br.com.nortesys.clinicplus.domain.TipoConvenio;

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
public class TipoConvenioBean {

    private TipoConvenio tipoConvenio;
    private List<TipoConvenio> tipoConvenios;

    private Convenio convenio;
    private List<Convenio> convenios;

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

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @PostConstruct
    public void listar() {
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipoconvenio");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            TipoConvenio[] vetor = gson.fromJson(json, TipoConvenio[].class);

            tipoConvenios = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {

        try {

            tipoConvenio = new TipoConvenio();
            convenio = new Convenio();

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipoconvenio");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Convenio[] vetor = gson.fromJson(json, Convenio[].class);

            convenios = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }

    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipoconvenio");

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String json = gson.toJson(tipoConvenio);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            TipoConvenio[] vetor = gson.fromJson(json, TipoConvenio[].class);
            tipoConvenios = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            tipoConvenio = (TipoConvenio) evento.getComponent().getAttributes().get("Selecionado");

            //novo();
            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipoconvenio/");

            caminho.path("{codigo}").resolveTemplate("codigo", tipoConvenio.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            TipoConvenio[] vetor = gson.fromJson(json, TipoConvenio[].class);

            tipoConvenios = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        try {

            tipoConvenio = (TipoConvenio) evento.getComponent().getAttributes().get("Selecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/convenio");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Convenio[] vetor = gson.fromJson(json, Convenio[].class);

            convenios = Arrays.asList(vetor);

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Ocorreu erro ao tentar selecionar Convênio!");
            erro.printStackTrace();
        }

    }

}
