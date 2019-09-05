
package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Contato;
import br.com.nortesys.clinicplus.service.ContatoService;

import com.google.gson.Gson;
import java.util.Arrays;
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
 * @author Francisco
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContatoBean {
    
    private Contato contato;
    private List<Contato> contatos;

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
    
    @PostConstruct
    public void listar() {
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/contato");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Contato[] vetor = gson.fromJson(json, Contato[].class);

            contatos = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        contato = new Contato();
    }

    public void salvar() {

        try {

            ContatoService contatoService = new ContatoService();

            novo();
            listar();

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Erro ao tentar gravar Registro");
            erro.printStackTrace();
        }
        
    }

    public void excluir(ActionEvent evento) {
        try {
            contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionada");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/contato/");

            caminho.path("{codigo}").resolveTemplate("codigo", contato.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Contato[] vetor = gson.fromJson(json, Contato[].class);

            contatos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionada");
    }
    
}
