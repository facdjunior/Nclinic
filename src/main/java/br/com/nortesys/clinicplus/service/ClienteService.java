package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ClienteDAO;
import br.com.nortesys.clinicplus.domain.Cliente;
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
 * @author Francisco
 */
@Path("cliente")
public class ClienteService {
    
    //http://localhost:8080/ClinicPlus/clinic/convenio 
    @GET
    public String listar() {

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listar("codigo");

        Gson gson = new Gson();
        String json = gson.toJson(clientes);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenio/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(cliente);

        return json;
    }
    //http://localhost:8080/ClinicPlus/clinic/convenio/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.merge(cliente);
        
        String jsonSaida = gson.toJson(cliente);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinc/convenio/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editar(cliente);
        
        String jsonSaida = gson.toJson(cliente);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinic/convenio/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo")Long codigo){
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        Cliente cliente = clienteDAO.buscar(codigo);
        clienteDAO.excluir(cliente);
        
        Gson gson = new Gson();
        String saida = gson.toJson(cliente);
        return saida;
    }
    
    
}
