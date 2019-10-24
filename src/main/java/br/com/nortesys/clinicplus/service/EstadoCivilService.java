package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.EstadoCivilDAO;
import br.com.nortesys.clinicplus.domain.EstadoCivil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
 * @author Francisco
 */
@Path("estadoCivil")
public class EstadoCivilService {

    //http://localhost:8080/ClinicPlus/clinic/estadoCivil 
    @GET
    public String listar() {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> estadoCivils = estadoCivilDAO.listar("Descricao");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(estadoCivils);

        return json;
    }

    //http://localhost:8080/ClinicPlus/rest/estadoCivil/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(estadoCivil);

        return json;
    }

    //http://localhost:8080/ClinicPlus/rest/estadoCivil/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        EstadoCivil estadoCivil = gson.fromJson(json, EstadoCivil.class);

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil resultado = (EstadoCivil) estadoCivilDAO.listarSequencia();

        if (resultado == null) {

            estadoCivil.setDataCadastro(new Date());
            estadoCivil.setSequencia(1);
            estadoCivilDAO.merge(estadoCivil);

            String jsonSaida = gson.toJson(estadoCivil);
            return jsonSaida;
        }
        estadoCivil.setDataCadastro(new Date());
        estadoCivil.setSequencia(resultado.getSequencia() + 1);
        estadoCivilDAO.merge(estadoCivil);

        String jsonSaida = gson.toJson(estadoCivil);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/estadoCivil/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        EstadoCivil estadoCivil = gson.fromJson(json, EstadoCivil.class);

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        estadoCivilDAO.editar(estadoCivil);

        String jsonSaida = gson.toJson(estadoCivil);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/rest/estadoCivil/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();

        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);
        estadoCivilDAO.excluir(estadoCivil);

        Gson gson = new Gson();
        String saida = gson.toJson(estadoCivil);
        return saida;
    }

}
