package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.DocumentoDAO;
import br.com.nortesys.clinicplus.domain.Documento;
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
@Path("documento")
public class DocumentoService {

    //http://localhost:8080/ClinicPlus/clinic/documento 
    @GET
    public String listar() {

        DocumentoDAO documentoDAO = new DocumentoDAO();
        List<Documento> documentos = documentoDAO.listar("codigo");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(documentos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/rest/documento/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento documento = documentoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(documento);

        return json;
    }

    //http://localhost:8080/ClinicPlus/rest/documento/
    @POST
    public String salvar(String json) {

        Gson gson = new Gson();
        Documento documento = gson.fromJson(json, Documento.class);

        DocumentoDAO documentoDAO = new DocumentoDAO();
        Documento resultado = (Documento) documentoDAO.listarSequencia();

        if (resultado == null) {

            documento.setDataCadastro(new Date());
            documento.setSequencia(1);
            documentoDAO.merge(documento);

            String jsonSaida = gson.toJson(documento);
            return jsonSaida;
        }
        documento.setDataCadastro(new Date());
        documento.setSequencia(resultado.getSequencia() + 1);
        documentoDAO.merge(documento);

        String jsonSaida = gson.toJson(documento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/rest/documento/
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        Documento documento = gson.fromJson(json, Documento.class);

        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDAO.editar(documento);

        String jsonSaida = gson.toJson(documento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/rest/documento/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        DocumentoDAO documentoDAO = new DocumentoDAO();

        Documento documento = documentoDAO.buscar(codigo);
        documentoDAO.excluir(documento);

        Gson gson = new Gson();
        String saida = gson.toJson(documento);
        return saida;
    }
}
