package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ConvenioDAO;
import br.com.nortesys.clinicplus.domain.Convenio;
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
 * @author Francisco Junior
 */
@Path("convenio")
public class ConvenioService {

    //http://localhost:8080/ClinicPlus/clinic/convenio 
    @GET
    public String listar() {

        ConvenioDAO convenioDAO = new ConvenioDAO();
        List<Convenio> convenios = convenioDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(convenios);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenio/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio convenio = convenioDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(convenio);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenio/
    @POST
    public String salvar(String json) {

        
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        Convenio convenio = gson.fromJson(json, Convenio.class);

        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio resultado = (Convenio) convenioDAO.listarSequencia();

        if (resultado == null) {
            convenio.setDataCadastro(new Date());
            convenio.setSequencia(1);
            convenioDAO.merge(convenio);

            String jsonSaida = gson.toJson(convenio);
            return jsonSaida;
        }
        convenio.setDataCadastro(new Date());
        convenio.setSequencia(resultado.getSequencia() + 1);
        convenioDAO.merge(convenio);

        String jsonSaida = gson.toJson(convenio);
        return jsonSaida;

    }

    //http://localhost:8080/ClinicPlus/clinc/convenio/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Convenio convenio = gson.fromJson(json, Convenio.class);

        ConvenioDAO convenioDAO = new ConvenioDAO();
        convenioDAO.editar(convenio);

        String jsonSaida = gson.toJson(convenio);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenio/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        ConvenioDAO convenioDAO = new ConvenioDAO();

        Convenio convenio = convenioDAO.buscar(codigo);
        convenioDAO.excluir(convenio);

        Gson gson = new Gson();
        String saida = gson.toJson(convenio);
        return saida;
    }

}
