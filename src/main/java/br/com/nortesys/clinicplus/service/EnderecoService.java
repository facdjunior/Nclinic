package br.com.nortesys.clinicplus.service;


import br.com.nortesys.clinicplus.dao.EnderecoDAO;
import br.com.nortesys.clinicplus.domain.Endereco;
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

@Path("endereco")
public class EnderecoService {
    
    //http://localhost:8080/ClinicPlus/clinic/endereco 
    @GET
    public String listar() {

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> enderecos = enderecoDAO.listar("codigo");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(enderecos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/endereco
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(endereco);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/endereco/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(json, Endereco.class);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.merge(endereco);

        String jsonSaida = gson.toJson(endereco);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/endereco/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(json, Endereco.class);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.editar(endereco);

        String jsonSaida = gson.toJson(endereco);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/endereco/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        Endereco endereco = enderecoDAO.buscar(codigo);
        enderecoDAO.excluir(endereco);

        Gson gson = new Gson();
        String saida = gson.toJson(endereco);
        return saida;
    }
    
}
