package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ContatoDAO;
import br.com.nortesys.clinicplus.domain.Contato;
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
 * @author Francisco
 */
@Path("contato")
public class ContatoService {

    //http://localhost:8080/ClinicPlus/clinic/contato 
    @GET
    public String listar() {

        ContatoDAO contatoDAO = new ContatoDAO();
        List<Contato> contatos = contatoDAO.listar("codigo");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contatos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/contato
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = contatoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(contato);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/contato/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Contato contato = gson.fromJson(json, Contato.class);

        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.merge(contato);

        String jsonSaida = gson.toJson(contato);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/contato/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Contato contato = gson.fromJson(json, Contato.class);

        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.editar(contato);

        String jsonSaida = gson.toJson(contato);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/contato/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        ContatoDAO contatoDAO = new ContatoDAO();

        Contato contato = contatoDAO.buscar(codigo);
        contatoDAO.excluir(contato);

        Gson gson = new Gson();
        String saida = gson.toJson(contato);
        return saida;
    }
}
