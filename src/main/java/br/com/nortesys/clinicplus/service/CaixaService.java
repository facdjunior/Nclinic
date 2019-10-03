package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.CaixaDAO;
import br.com.nortesys.clinicplus.domain.financeiro.Caixa;
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
 * @author Francisco
 */
@Path("caixa")
public class CaixaService {

    //http://localhost:8080/ClinicPlus/clinic/caixa 
    @GET
    public String listar() {

        CaixaDAO caixaDAO = new CaixaDAO();
        List<Caixa> caixas = caixaDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(caixas);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixa/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = caixaDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(caixa);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixa/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Caixa caixa = gson.fromJson(json, Caixa.class);

        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa resultado = (Caixa) caixaDAO.listarSequencia();

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

    //http://localhost:8080/ClinicPlus/clinc/caixa/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Caixa caixa = gson.fromJson(json, Caixa.class);

        CaixaDAO caixaDAO = new CaixaDAO();
        caixaDAO.editar(caixa);

        String jsonSaida = gson.toJson(caixa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/caixa/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        CaixaDAO caixaDAO = new CaixaDAO();

        Caixa caixa = caixaDAO.buscar(codigo);
        caixaDAO.excluir(caixa);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(caixa);
        return saida;
    }

}
