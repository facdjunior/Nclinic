package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.PessoaFisicaDAO;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
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
@Path("pessoaFisica")
public class PessoaFisicaService {

    //http://localhost:8080/ClinicPlus/clinic/pessoaFisica 
    @GET
    public String listar() {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> pessoaFisicas = pessoaFisicaDAO.listar("codigo");

        Gson gson = new Gson();
        String json = gson.toJson(pessoaFisicas);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/pessoaFisica
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = pessoaFisicaDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(pessoaFisica);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/pessoaFisica/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        PessoaFisica pessoaFisica = gson.fromJson(json, PessoaFisica.class);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.merge(pessoaFisica);

        String jsonSaida = gson.toJson(pessoaFisica);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/pessoaFisica/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        PessoaFisica pessoaFisica = gson.fromJson(json, PessoaFisica.class);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.editar(pessoaFisica);

        String jsonSaida = gson.toJson(pessoaFisica);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/pessoaFisica/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

        PessoaFisica pessoaFisica = pessoaFisicaDAO.buscar(codigo);
        pessoaFisicaDAO.excluir(pessoaFisica);

        Gson gson = new Gson();
        String saida = gson.toJson(pessoaFisica);
        return saida;
    }

}
