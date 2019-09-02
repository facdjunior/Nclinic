package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.TipoFuncionarioDAO;
import br.com.nortesys.clinicplus.domain.TipoFuncionario;
import com.google.gson.Gson;
import java.util.Date;
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
@Path("tipofuncionario")
public class TipoFuncionarioService {

    //http://localhost:8080/ClinicPlus/clinic/tipofuncionario
    @GET
    public String listar() {

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        List<TipoFuncionario> tipoFuncionarios = tipoFuncionarioDAO.listar("Descricao");

        Gson gson = new Gson();
        String json = gson.toJson(tipoFuncionarios);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(tipoFuncionario);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();

        TipoFuncionario tipoFuncionario = gson.fromJson(json, TipoFuncionario.class);

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario resultado = (TipoFuncionario) tipoFuncionarioDAO.listarSequencia();

        if (resultado == null) {
            tipoFuncionario.setSequencia(1);
            tipoFuncionario.setDataCadastro(new Date());
            tipoFuncionarioDAO.merge(tipoFuncionario);

            String jsonSaida = gson.toJson(tipoFuncionario);
            return jsonSaida;
            
        }
        tipoFuncionario.setSequencia(resultado.getSequencia() + 1);
        tipoFuncionario.setDataCadastro(new Date());
        tipoFuncionarioDAO.merge(tipoFuncionario);

        String jsonSaida = gson.toJson(tipoFuncionario);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/tipodocumento/
    @PUT
    public String editar(String json
    ) {

        Gson gson = new Gson();
        TipoFuncionario tipoFuncionario = gson.fromJson(json, TipoFuncionario.class);

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        tipoFuncionarioDAO.editar(tipoFuncionario);

        String jsonSaida = gson.toJson(tipoFuncionario);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo
    ) {

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();

        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);
        tipoFuncionarioDAO.excluir(tipoFuncionario);

        Gson gson = new Gson();
        String saida = gson.toJson(tipoFuncionario);
        return saida;
    }
}
