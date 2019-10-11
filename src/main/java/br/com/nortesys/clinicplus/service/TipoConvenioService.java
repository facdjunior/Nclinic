package br.com.nortesys.clinicplus.service;


import br.com.nortesys.clinicplus.dao.TipoConvenioDAO;
import br.com.nortesys.clinicplus.domain.TipoConvenio;
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
@Path("tipoconvenio")
public class TipoConvenioService {

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio 
    @GET
    public String listar() {

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        List<TipoConvenio> tipoConvenios = tipoConvenioDAO.listar("Descricao");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(tipoConvenios);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        TipoConvenio tipoConvenio = tipoConvenioDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(tipoConvenio);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        TipoConvenio tipoConvenio = gson.fromJson(json, TipoConvenio.class);

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        TipoConvenio resultado = tipoConvenioDAO.listarSequencia();

        if (resultado == null) {

        
            tipoConvenio.setSequencia(1);
            tipoConvenio.setDataCadastro(new Date());
            tipoConvenioDAO.merge(tipoConvenio);

            String jsonSaida = gson.toJson(tipoConvenio);
            return jsonSaida;

        }
        
        tipoConvenio.setSequencia(resultado.getSequencia()+1);
        tipoConvenio.setDataCadastro(new Date());
        tipoConvenioDAO.merge(tipoConvenio);

        String jsonSaida = gson.toJson(tipoConvenio);
        return jsonSaida;

    }

    //http://localhost:8080/ClinicPlus/clinc/tipoconvenio/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        TipoConvenio tipoConvenio = gson.fromJson(json, TipoConvenio.class);

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();
        tipoConvenioDAO.editar(tipoConvenio);

        String jsonSaida = gson.toJson(tipoConvenio);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipoconvenio/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        TipoConvenioDAO tipoConvenioDAO = new TipoConvenioDAO();

        TipoConvenio tipoConvenio = tipoConvenioDAO.buscar(codigo);
        tipoConvenioDAO.excluir(tipoConvenio);

        Gson gson = new Gson();
        String saida = gson.toJson(tipoConvenio);
        return saida;
    }

}
