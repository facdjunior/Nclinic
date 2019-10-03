package br.com.nortesys.clinicplus.bean.financeiro;

import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
import br.com.nortesys.clinicplus.domain.financeiro.CaixaAberturaFechamento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Francisco Junior
 */
public class CaixaAberturaFechamentoBean implements Serializable{
    
    private CaixaAberturaFechamento caixaAberturaFechamento;
    private List<CaixaAberturaFechamento> caixaAberturaFechamentos;
    
    private Caixa caixa;
    private List<Caixa> caixas;

    public CaixaAberturaFechamento getCaixaAberturaFechamento() {
        return caixaAberturaFechamento;
    }

    public void setCaixaAberturaFechamento(CaixaAberturaFechamento caixaAberturaFechamento) {
        this.caixaAberturaFechamento = caixaAberturaFechamento;
    }

    public List<CaixaAberturaFechamento> getCaixaAberturaFechamentos() {
        return caixaAberturaFechamentos;
    }

    public void setCaixaAberturaFechamentos(List<CaixaAberturaFechamento> caixaAberturaFechamentos) {
        this.caixaAberturaFechamentos = caixaAberturaFechamentos;
    }

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
    public void listar(){
        
        try {

            Client cliente = ClientBuilder.newClient();
            WebTarget caminho = cliente.target("http://127.0.0.1:8080/ClinicPlus/clinic/caixaabertura");
            String json = caminho.request().get(String.class);

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            Caixa[] vetor = gson.fromJson(json, Caixa[].class);

            caixas = Arrays.asList(vetor);

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar registros");
            erro.printStackTrace();
        }
    }
    
    public void salvar(){
        
    }
    
    public void novo(){
        
    }
    
    public void editar(ActionEvent evento){
        
    }
    
    public void excluir(ActionEvent evento){
        
    }
    
}
