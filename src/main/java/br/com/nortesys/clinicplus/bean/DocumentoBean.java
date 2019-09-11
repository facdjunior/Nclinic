
package br.com.nortesys.clinicplus.bean;


import br.com.nortesys.clinicplus.domain.Documento;
import br.com.nortesys.clinicplus.service.DocumentoService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
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
public class DocumentoBean {
    
    private Documento documento;
    private List<Documento> documentos;

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
    
     public void novo() {
        documento = new Documento();
    }

    public void salvar() {

        try {

            DocumentoService documentoService = new DocumentoService();

            novo();
            

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {

            Messages.addGlobalError("Erro ao tentar gravar Registro");
            erro.printStackTrace();
        }
        /*
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/documento");

            Gson gson = new Gson();
            String json = gson.toJson(documento);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            Documento[] vetor = gson.fromJson(json, Documento[].class);
            documentos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }*/
    }

    public void excluir(ActionEvent evento) {
        try {
            documento = (Documento) evento.getComponent().getAttributes().get("documentoSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/documento/");

            caminho.path("{codigo}").resolveTemplate("codigo", documento.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            Documento[] vetor = gson.fromJson(json, Documento[].class);

            documentos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        documento = (Documento) evento.getComponent().getAttributes().get("documentoSelecionado");
    }
    
}
