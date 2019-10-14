
package br.com.nortesys.clinicplus.service;


import br.com.nortesys.clinicplus.dao.ProcedimentoDAO;
import br.com.nortesys.clinicplus.domain.Procedimento;
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
@Path("procedimento")
public class ProcedimentoService {
    
    //http://localhost:8080/ClinicPlus/clinic/procedimento 
    @GET
    public String listar() {

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        List<Procedimento> procedimentos = procedimentoDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(procedimentos);

        return json;
    }
    
    //http://localhost:8080/ClinicPlus/clinic/procedimento/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        Procedimento procedimento = procedimentoDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(procedimento);

        return json;
    }
    
    //http://localhost:8080/ClinicPlus/clinic/procedimento/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Procedimento procedimento = gson.fromJson(json, Procedimento.class);

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        Procedimento resultado = (Procedimento) procedimentoDAO.listarSequencia();
        
        procedimento.setSequencia(resultado.getSequencia() + 1L);
        procedimento.setDataCadastro(new Date());

        procedimentoDAO.merge(procedimento);
        
        String jsonSaida = gson.toJson(procedimento);
        return jsonSaida;
    }
    
    //http://localhost:8080/ClinicPlus/clinc/procedimento/
    @PUT
    public String editar(String json
    ) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Procedimento procedimento = gson.fromJson(json, Procedimento.class);

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        procedimentoDAO.merge(procedimento);

        String jsonSaida = gson.toJson(procedimento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/procedimento/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo
    ) {

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();

        Procedimento procedimento = procedimentoDAO.buscar(codigo);
        procedimentoDAO.excluir(procedimento);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(procedimento);
        return saida;
    }
}
