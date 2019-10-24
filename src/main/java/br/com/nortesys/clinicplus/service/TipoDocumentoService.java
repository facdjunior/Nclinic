package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.TipoDocumentoDAO;
import br.com.nortesys.clinicplus.domain.TipoDocumento;
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
 * @author Francisco Junior
 */
@Path("tipodocumento")
public class TipoDocumentoService {

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento
    @GET
    public String listar() {

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        List<TipoDocumento> tipoDocumentos = tipoDocumentoDAO.listar("Descricao");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(tipoDocumentos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(tipoDocumento);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        TipoDocumento tipoDocumento = gson.fromJson(json, TipoDocumento.class);

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tipoDocumentoDAO.merge(tipoDocumento);

        String jsonSaida = gson.toJson(tipoDocumento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/tipodocumento/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        TipoDocumento tipoDocumento = gson.fromJson(json, TipoDocumento.class);

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tipoDocumentoDAO.editar(tipoDocumento);

        String jsonSaida = gson.toJson(tipoDocumento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipodocumento/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();

        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(codigo);
        tipoDocumentoDAO.excluir(tipoDocumento);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String saida = gson.toJson(tipoDocumento);
        return saida;
    }
}
