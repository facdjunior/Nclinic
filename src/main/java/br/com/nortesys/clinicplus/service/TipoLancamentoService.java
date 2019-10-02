package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.ModalidadeLancamentoDAO;
import br.com.nortesys.clinicplus.dao.TipoLancamentoDAO;
import br.com.nortesys.clinicplus.domain.ModalidadeLancamento;
import br.com.nortesys.clinicplus.domain.TipoLancamentos;
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
@Path("tipolancamento")
public class TipoLancamentoService {

    //http://localhost:8080/ClinicPlus/clinic/tipolancamento
    @GET
    public String listar() {

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        List<TipoLancamentos> tipoLancamentos = tipoLancamentoDAO.listar("Descricao");

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(tipoLancamentos);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipolancamento/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos tipoLancamento = tipoLancamentoDAO.buscar(codigo);

        Gson gson = new Gson();
        String json = gson.toJson(tipoLancamento);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipolancamento
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        TipoLancamentos tipoLancamento = gson.fromJson(json, TipoLancamentos.class);

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        TipoLancamentos resultado = tipoLancamentoDAO.listarSequencia();
        
        if (resultado == null) {

            tipoLancamento.setSequencia(1L);
            tipoLancamento.setDataCadastro(new Date());
            tipoLancamento.setModalidadeLancamento(tipoLancamento.getModalidadeLancamento());

        } else {

            tipoLancamento.setSequencia(resultado.getSequencia() + 1);
            tipoLancamento.setDataCadastro(new Date());
            tipoLancamento.setModalidadeLancamento(tipoLancamento.getModalidadeLancamento());
        }
        tipoLancamentoDAO.merge(tipoLancamento);

        String jsonSaida = gson.toJson(tipoLancamento);
        return jsonSaida;

    }

    //http://localhost:8080/ClinicPlus/clinc/tipolancamento
    @PUT
    public String editar(String json) {

        Gson gson = new Gson();
        TipoLancamentos tipoLancamento = gson.fromJson(json, TipoLancamentos.class);

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();
        tipoLancamentoDAO.editar(tipoLancamento);

        String jsonSaida = gson.toJson(tipoLancamento);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/tipolancamento/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        TipoLancamentoDAO tipoLancamentoDAO = new TipoLancamentoDAO();

        TipoLancamentos tipoLancamento = tipoLancamentoDAO.buscar(codigo);
        tipoLancamentoDAO.excluir(tipoLancamento);

        Gson gson = new Gson();
        String saida = gson.toJson(tipoLancamento);
        return saida;
    }

}
