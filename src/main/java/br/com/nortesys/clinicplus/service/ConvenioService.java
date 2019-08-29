package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.domain.Convenio;
import com.google.gson.Gson;
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
@Path("convenio")
public class ConvenioService {
    
    //http://localhost:8080/ClinicPlus/clinic/convenio 
    @GET
    public String listar() {

        ConvenioDAO profissaoDAO = new ConvenioDAO();
        List<Convenio> convenios = profissaoDAO.listar("Descricao");

        Gson gson = new Gson();
        String json = gson.toJson(convenios);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenio/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ConvenioDAO profissaoDAO = new ConvenioDAO();
        Convenio profissao = profissaoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(profissao);

        return json;
    }
    //http://localhost:8080/ClinicPlus/clinic/convenio/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Convenio profissao = gson.fromJson(json, Convenio.class);

        ConvenioDAO profissaoDAO = new ConvenioDAO();
        profissaoDAO.merge(profissao);
        
        String jsonSaida = gson.toJson(profissao);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinc/convenio/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Convenio profissao = gson.fromJson(json, Convenio.class);

        ConvenioDAO profissaoDAO = new ConvenioDAO();
        profissaoDAO.editar(profissao);
        
        String jsonSaida = gson.toJson(profissao);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinic/convenio/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo")Long codigo){
        
        ConvenioDAO profissaoDAO = new ConvenioDAO();
        
        Convenio profissao = profissaoDAO.buscar(codigo);
        profissaoDAO.excluir(profissao);
        
        Gson gson = new Gson();
        String saida = gson.toJson(profissao);
        return saida;
    }
    
}
