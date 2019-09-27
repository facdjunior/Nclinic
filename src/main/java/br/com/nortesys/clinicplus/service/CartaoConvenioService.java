package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.CartaoConvenioDAO;
import br.com.nortesys.clinicplus.domain.CartaoConvenio;
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
@Path("cartaoconvenio")
public class CartaoConvenioService {

    //http://localhost:8080/ClinicPlus/clinic/cartaoconvenio
    @GET
    public String listar() {

        CartaoConvenioDAO cartaoConvenioDAO = new CartaoConvenioDAO();
        List<CartaoConvenio> cartaoConvenios = cartaoConvenioDAO.listar();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //Gson gson1 = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(cartaoConvenios);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/cartaoconvenio/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        CartaoConvenioDAO cartaoConvenioDAO = new CartaoConvenioDAO();
        CartaoConvenio cartaoConvenio = cartaoConvenioDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(cartaoConvenio);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/cartaoconvenio/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        CartaoConvenio cartaoConvenio = gson.fromJson(json, CartaoConvenio.class);

        CartaoConvenioDAO cartaoConvenioDAO = new CartaoConvenioDAO();
        cartaoConvenioDAO.merge(cartaoConvenio);

        String jsonSaida = gson.toJson(cartaoConvenio);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/cartaoconvenio/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        CartaoConvenio cartaoConvenio = gson.fromJson(json, CartaoConvenio.class);

        CartaoConvenioDAO clienteDAO = new CartaoConvenioDAO();
        clienteDAO.editar(cartaoConvenio);

        String jsonSaida = gson.toJson(cartaoConvenio);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/cartaoconvenio/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        CartaoConvenioDAO cartaoConvenioDAO = new CartaoConvenioDAO();

        CartaoConvenio cartaoConvenio = cartaoConvenioDAO.buscar(codigo);
        cartaoConvenioDAO.excluir(cartaoConvenio);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String saida = gson.toJson(cartaoConvenio);
        return saida;
    }
}
