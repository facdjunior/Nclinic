package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.DocumentoDAO;
import br.com.nortesys.clinicplus.dao.EnderecoDAO;
import br.com.nortesys.clinicplus.dao.PessoaDAO;
import br.com.nortesys.clinicplus.domain.Pessoa;
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
@Path("pessoa")
public class PessoaService {

    //http://localhost:8080/ClinicPlus/clinic/pessoa 
    @GET
    public String listar() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        DocumentoDAO documentoDAO = new DocumentoDAO();
        
        List<Pessoa> pessoas = pessoaDAO.listar("Nome");

        Gson gson = new Gson();
        String json = gson.toJson(pessoas);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/pessoa/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(pessoa);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/pessoa/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.merge(pessoa);

        String jsonSaida = gson.toJson(pessoa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/pessoa/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.editar(pessoa);

        String jsonSaida = gson.toJson(pessoa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/pessoa/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        PessoaDAO pessoaDAO = new PessoaDAO();

        Pessoa pessoa = pessoaDAO.buscar(codigo);
        pessoaDAO.excluir(pessoa);

        Gson gson = new Gson();
        String saida = gson.toJson(pessoa);
        return saida;
    }

}
