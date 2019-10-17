package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ConvenioAssociadoDAO;
import br.com.nortesys.clinicplus.domain.ConvenioAssociado;
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
@Path("convenioassociado")
public class ConvenioAssociadoService {

    //http://localhost:8080/ClinicPlus/clinic/convenioassociado 
    @GET
    public String listar() {

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        List<ConvenioAssociado> convenioAssociados = convenioAssociadoDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(convenioAssociados);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenioassociado/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(convenioAssociado);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenioassociado/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        ConvenioAssociado convenioAssociado = gson.fromJson(json, ConvenioAssociado.class);

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        ConvenioAssociado resultado = (ConvenioAssociado) convenioAssociadoDAO.listarSequencia();

        if (resultado == null) {
            convenioAssociado.setDataCadastro(new Date());
            convenioAssociado.setSequencia(1L);
            

        } else {
            convenioAssociado.setDataCadastro(new Date());
            convenioAssociado.setSequencia(resultado.getSequencia() + 1L);
            
        }

        convenioAssociadoDAO.merge(convenioAssociado);

        String jsonSaida = gson.toJson(convenioAssociado);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/convenioassociado/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        ConvenioAssociado convenioAssociado = gson.fromJson(json, ConvenioAssociado.class);

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();
        convenioAssociadoDAO.editar(convenioAssociado);

        String jsonSaida = gson.toJson(convenioAssociado);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/convenioassociado/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        ConvenioAssociadoDAO convenioAssociadoDAO = new ConvenioAssociadoDAO();

        ConvenioAssociado convenioAssociado = convenioAssociadoDAO.buscar(codigo);
        convenioAssociadoDAO.excluir(convenioAssociado);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(convenioAssociado);
        return saida;
    }

}
