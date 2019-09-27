package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ClienteDAO;
import br.com.nortesys.clinicplus.domain.Cliente;
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
@Path("cliente")
public class ClienteService {

    //http://localhost:8080/ClinicPlus/clinic/cliente 
    @GET
    public String listar() {

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listaCliente();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(clientes);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/cliente/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarCliente(codigo);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(cliente);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/cliente/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.merge(cliente);

        String jsonSaida = gson.toJson(cliente);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/cliente/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editar(cliente);

        String jsonSaida = gson.toJson(cliente);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/cliente/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = clienteDAO.buscar(codigo);
        clienteDAO.excluir(cliente);

        Gson gson = new Gson();
        String saida = gson.toJson(cliente);
        return saida;
    }

    public Cliente buscarEnderecoPor(String urlJson) {

        System.out.println("Iniciou pesquisa....");

        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        Gson g = new Gson();

        Cliente retornoEndereco = gson.fromJson(urlJson, Cliente.class);
        return retornoEndereco;
    }

}
