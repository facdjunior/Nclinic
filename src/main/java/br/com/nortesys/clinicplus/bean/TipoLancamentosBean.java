package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.ModalidadeLancamentoDAO;
import br.com.nortesys.clinicplus.domain.ModalidadeLancamento;
import br.com.nortesys.clinicplus.domain.TipoLancamentos;
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
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoLancamentosBean {

    private TipoLancamentos tipoLancamento;
    private List<TipoLancamentos> tipoLancamentos;

    private ModalidadeLancamento modalidadeLancamento;

    private List<ModalidadeLancamento> modalidadeLancamentos;

    public TipoLancamentos getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamentos tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public ModalidadeLancamento getModalidadeLancamento() {
        return modalidadeLancamento;
    }

    public List<TipoLancamentos> getTipoLancamentos() {
        return tipoLancamentos;
    }

    public void setTipoLancamentos(List<TipoLancamentos> tipoLancamentos) {
        this.tipoLancamentos = tipoLancamentos;
    }

    public void setModalidadeLancamento(ModalidadeLancamento modalidadeLancamento) {
        this.modalidadeLancamento = modalidadeLancamento;
    }

    public List<ModalidadeLancamento> getModalidadeLancamentos() {
        return modalidadeLancamentos;
    }

    public void setModalidadeLancamentos(List<ModalidadeLancamento> modalidadeLancamentos) {
        this.modalidadeLancamentos = modalidadeLancamentos;
    }

    @PostConstruct
    public void listar() {
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipolancamento");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            TipoLancamentos[] vetor = gson.fromJson(json, TipoLancamentos[].class);

            tipoLancamentos = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {

        tipoLancamento = new TipoLancamentos();

        modalidadeLancamento = new ModalidadeLancamento();
        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        modalidadeLancamentos = modalidadeLancamentoDAO.listar("Descricao");

    }

    public void salvar() {

        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/tipolancamento");

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String json = gson.toJson(tipoLancamento);
            caminho.request().post(Entity.json(json));

            novo();

            json = caminho.request().get(String.class);
            TipoLancamentos[] vetor = gson.fromJson(json, TipoLancamentos[].class);
            tipoLancamentos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro gravado com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            tipoLancamento = (TipoLancamentos) evento.getComponent().getAttributes().get("tplancamentoSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://localhost:8080/ClinicPlus/clinic/tipolancamento/");

            caminho.path("{codigo}").resolveTemplate("codigo", tipoLancamento.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            TipoLancamentos[] vetor = gson.fromJson(json, TipoLancamentos[].class);

            tipoLancamentos = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");

        } catch (RuntimeException erro) {

            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        tipoLancamento = (TipoLancamentos) evento.getComponent().getAttributes().get("tplancamentoSelecionado");

        ModalidadeLancamentoDAO modalidadeLancamentoDAO = new ModalidadeLancamentoDAO();
        modalidadeLancamentos = modalidadeLancamentoDAO.listar("Descricao");
    }
}
