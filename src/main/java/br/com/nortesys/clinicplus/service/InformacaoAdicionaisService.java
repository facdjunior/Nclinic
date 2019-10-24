package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.InformacaoAdicionalDAO;
import br.com.nortesys.clinicplus.domain.InformacaoAdicional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@Path("informacaoadicionais")
public class InformacaoAdicionaisService {

    @GET
    public String listar() {
        //http://localhost:8080/ClinicPlus/clinic/informacaoadicionais
        
        InformacaoAdicionalDAO informacaoAdicionalDAO = new InformacaoAdicionalDAO();
        List<InformacaoAdicional> contatos = informacaoAdicionalDAO.listar("codigo");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contatos);

        return json;
    }
    
    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/contato
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        InformacaoAdicionalDAO informacaoAdicionalDAO = new InformacaoAdicionalDAO();
        InformacaoAdicional informacaoAdicional = informacaoAdicionalDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(informacaoAdicional);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/contato/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        InformacaoAdicional informacaoAdicional = gson.fromJson(json, InformacaoAdicional.class);

        InformacaoAdicionalDAO informacaoAdicionalDAO = new InformacaoAdicionalDAO();
        informacaoAdicionalDAO.merge(informacaoAdicional);

        String jsonSaida = gson.toJson(informacaoAdicional);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/contato/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        InformacaoAdicional informacaoAdicional = gson.fromJson(json, InformacaoAdicional.class);

        InformacaoAdicionalDAO informacaoAdicionalDAO = new InformacaoAdicionalDAO();
        informacaoAdicionalDAO.editar(informacaoAdicional);

        String jsonSaida = gson.toJson(informacaoAdicional);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/contato/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        InformacaoAdicionalDAO informacaoAdicionalDAO = new InformacaoAdicionalDAO();

        InformacaoAdicional informacaoAdicional = informacaoAdicionalDAO.buscar(codigo);
        informacaoAdicionalDAO.excluir(informacaoAdicional);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String saida = gson.toJson(informacaoAdicional);
        return saida;
    }
}
