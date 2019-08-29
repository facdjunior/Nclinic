package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ProfissaoDAO;
import br.com.nortesys.clinicplus.domain.Profissao;

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
 * @author Francisco Junior 2019-08-29
 */
@Path("profissao")
public class ProfissaoService {
    
       //http://localhost:8080/ClinicPlus/clinic/profissao 
    @GET
    public String listar() {

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        List<Profissao> profissaos = profissaoDAO.listar("Descricao");

        Gson gson = new Gson();
        String json = gson.toJson(profissaos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/profissao/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        Profissao profissao = profissaoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(profissao);

        return json;
    }
    //http://localhost:8080/ClinicPlus/clinic/profissao/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Profissao profissao = gson.fromJson(json, Profissao.class);

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        profissaoDAO.merge(profissao);
        
        String jsonSaida = gson.toJson(profissao);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinc/profissao/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Profissao profissao = gson.fromJson(json, Profissao.class);

        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        profissaoDAO.merge(profissao);
        
        String jsonSaida = gson.toJson(profissao);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinic/profissao/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo")Long codigo){
        
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        
        Profissao profissao = profissaoDAO.buscar(codigo);
        profissaoDAO.excluir(profissao);
        
        Gson gson = new Gson();
        String saida = gson.toJson(profissao);
        return saida;
    }
    
}
