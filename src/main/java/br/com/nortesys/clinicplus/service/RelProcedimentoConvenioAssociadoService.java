package br.com.nortesys.clinicplus.service;


import br.com.nortesys.clinicplus.dao.RelProcedimentoConvenioAssociadoDAO;
import br.com.nortesys.clinicplus.domain.RelProcedimentoConvenioAssociado;
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
@Path("relProcedimentoConvenioAssociado")
public class RelProcedimentoConvenioAssociadoService {

    //http://localhost:8080/ClinicPlus/clinic/relProcedimentoConvenioAssociado 
    @GET
    public String listar() {

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        List<RelProcedimentoConvenioAssociado> relProcedimentoConvenioAssociados = relProcedimentoConvenioAssociadoDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(relProcedimentoConvenioAssociados);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/relProcedimentoConvenioAssociado/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        RelProcedimentoConvenioAssociado relProcedimentoConvenioAssociado = relProcedimentoConvenioAssociadoDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(relProcedimentoConvenioAssociado);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/relProcedimentoConvenioAssociado/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        RelProcedimentoConvenioAssociado relProcedimentoConvenioAssociado = gson.fromJson(json, RelProcedimentoConvenioAssociado.class);

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        RelProcedimentoConvenioAssociado resultado = (RelProcedimentoConvenioAssociado) relProcedimentoConvenioAssociadoDAO.listarSequencia();

        if (resultado == null) {
            relProcedimentoConvenioAssociado.setSequencia(1L);
            relProcedimentoConvenioAssociado.setDataCadastro(new Date());

            relProcedimentoConvenioAssociadoDAO.merge(relProcedimentoConvenioAssociado);

            String jsonSaida = gson.toJson(relProcedimentoConvenioAssociado);
            return jsonSaida;
        }
        relProcedimentoConvenioAssociado.setSequencia(resultado.getSequencia() + 1L);
        relProcedimentoConvenioAssociado.setDataCadastro(new Date());

        relProcedimentoConvenioAssociadoDAO.merge(relProcedimentoConvenioAssociado);

        String jsonSaida = gson.toJson(relProcedimentoConvenioAssociado);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/relProcedimentoConvenioAssociado/
    @PUT
    public String editar(String json
    ) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        
        RelProcedimentoConvenioAssociado relProcedimentoConvenioAssociado = gson.fromJson(json, RelProcedimentoConvenioAssociado.class);

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();
        relProcedimentoConvenioAssociadoDAO.merge(relProcedimentoConvenioAssociado);

        String jsonSaida = gson.toJson(relProcedimentoConvenioAssociado);
        return jsonSaida;
    }
    //http://localhost:8080/ClinicPlus/clinic/relProcedimentoConvenioAssociado/{codigo}

    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo
    ) {

        RelProcedimentoConvenioAssociadoDAO relProcedimentoConvenioAssociadoDAO = new RelProcedimentoConvenioAssociadoDAO();

        RelProcedimentoConvenioAssociado relProcedimentoConvenioAssociado = relProcedimentoConvenioAssociadoDAO.buscar(codigo);
        relProcedimentoConvenioAssociadoDAO.excluir(relProcedimentoConvenioAssociado);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(relProcedimentoConvenioAssociado);
        return saida;
    }

}
