package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.dao.PessoaFisicaDAO;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import br.com.nortesys.clinicplus.service.PessoaFisicaService;
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
public class PessoaFisicaBean {

    private PessoaFisica pessoaFisica;
    private List<PessoaFisica> pessoaFisicas;

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    @PostConstruct
    public void listar() {
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/pessoaFisica");
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            PessoaFisica[] vetor = gson.fromJson(json, PessoaFisica[].class);

            pessoaFisicas = Arrays.asList(vetor);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        pessoaFisica = new PessoaFisica();
    }

    public void salvar() {

        try {
            
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaFisica resultado = (PessoaFisica) pessoaFisicaDAO.listarSequencia();
              
            if (resultado == null) {

                    pessoaFisica.setDataCadastro(new Date());
                    pessoaFisica.setSequencia(1);
                    

                } else {

                    pessoaFisica.setDataCadastro(new Date());
                    pessoaFisica.setSequencia(resultado.getSequencia() + 1);
                    
                }
            
            
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();

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
            pessoaFisica = (PessoaFisica) evento.getComponent().getAttributes().get("pessoaFisicaSelecionado");

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho
                    = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/pessoaFisica/");

            caminho.path("{codigo}").resolveTemplate("codigo", pessoaFisica.getCodigo()).request().delete();
            String json = caminho.request().get(String.class);

            Gson gson = new Gson();
            PessoaFisica[] vetor = gson.fromJson(json, PessoaFisica[].class);

            pessoaFisicas = Arrays.asList(vetor);

            Messages.addGlobalInfo("Registro removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover Registro!");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        pessoaFisica = (PessoaFisica) evento.getComponent().getAttributes().get("pessoaFisicaSelecionado");
    }

    
}
