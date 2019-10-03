package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.financeiro.CaixaAberturaFechamentoDAO;
import br.com.nortesys.clinicplus.domain.financeiro.CaixaAberturaFechamento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Francisco Junior
 */

@Path("caixaabertura")
public class CaixaAberturaFechamentoService {
    

    //http://localhost:8080/ClinicPlus/clinic/caixaabertura 
    @GET
    public String listar() {

        CaixaAberturaFechamentoDAO caixaDAO = new CaixaAberturaFechamentoDAO();
        List<CaixaAberturaFechamento> aberturaFechamentos = caixaDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(aberturaFechamentos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixaabertura/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        CaixaAberturaFechamentoDAO caixaDAO = new CaixaAberturaFechamentoDAO();
        CaixaAberturaFechamento caixa = caixaDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(caixa);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixaabertura/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        CaixaAberturaFechamento caixa = gson.fromJson(json, CaixaAberturaFechamento.class);

        CaixaAberturaFechamentoDAO caixaDAO = new CaixaAberturaFechamentoDAO();
        CaixaAberturaFechamento resultado = (CaixaAberturaFechamento) caixaDAO.listarSequencia();

        if (resultado == null) {
            caixa.setDataCadastro(new Date());
            caixa.setSequencia(1L);
            caixa.setAtivo(true);

        } else {
            caixa.setDataCadastro(new Date());
            caixa.setSequencia(resultado.getSequencia() + 1L);
            caixa.setAtivo(true);
        }

        caixaDAO.merge(caixa);

        String jsonSaida = gson.toJson(caixa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/caixaabertura/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        CaixaAberturaFechamento caixa = gson.fromJson(json, CaixaAberturaFechamento.class);

        CaixaAberturaFechamentoDAO caixaDAO = new CaixaAberturaFechamentoDAO();
        caixaDAO.editar(caixa);

        String jsonSaida = gson.toJson(caixa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixaabertura/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        CaixaAberturaFechamentoDAO caixaDAO = new CaixaAberturaFechamentoDAO();

        CaixaAberturaFechamento caixa = caixaDAO.buscar(codigo);
        caixaDAO.excluir(caixa);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(caixa);
        return saida;
    }
    
}
